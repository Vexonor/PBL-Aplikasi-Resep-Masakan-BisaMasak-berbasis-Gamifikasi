<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\BahanResepModel;
use App\Models\KontenResepModel;
use App\Models\LangkahLangkahModel;
use DateTime;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;

class KontenTutorialApiController extends Controller
{
    public function index()
    {
        $data = KontenResepModel::with('BahanResepTable.BahanMasakTable', 'GiziTable', 'LangkahLangkahTable',)->get();
        return response()->json($data);
    }

    public function getMonthlyStats()
    {
        $rawStats = KontenResepModel::select(
            DB::raw('MONTH(created_at) as month'),
            'status_konten',
            DB::raw('COUNT(*) as total')
        )
            ->whereYear('created_at', date('Y'))
            ->groupBy('month', 'status_konten')
            ->orderBy('month')
            ->get();

        $statuses = KontenResepModel::select('status_konten')->distinct()->pluck('status_konten')->toArray();
        $result = [];

        for ($i = 1; $i <= 12; $i++) {
            $monthName = DateTime::createFromFormat('!m', $i)->format('F');
            $monthData = ['month' => $monthName];

            foreach ($statuses as $status) {
                $match = $rawStats->firstWhere(fn($item) => $item->month == $i && $item->status_konten == $status);
                $monthData[$status] = $match ? $match->total : 0;
            }

            $result[] = $monthData;
        }

        return response()->json($result);
    }

    public function search(Request $request)
    {
        $query = $request->input('q');
        $keywords = explode(' ', strtolower($query));

        $result = KontenResepModel::with(['BahanResepTable.BahanMasakTable'])
            ->judulKonten($keywords)
            ->get();

        return response()->json($result);
    }

    public function storeRecipe(Request $request)
    {
        DB::beginTransaction();

        Log::info('REQUEST RECEIVED');
        Log::info('REQUEST SEMUA', $request->all());

        if ($request->hasFile('video_tutorial')) {
            Log::info('Video tutorial diterima.');
            Log::info('Video Size: ' . $request->file('video_tutorial')->getSize());
            Log::info('Video MIME: ' . $request->file('video_tutorial')->getMimeType());
            Log::info('Video Original Name: ' . $request->file('video_tutorial')->getClientOriginalName());
        } else {
            Log::info('Video tutorial TIDAK diterima.');
        }

        try {
            $validated = $request->validate([
                'id_user' => 'required|integer|exists:users,id_user',
                'judul_konten' => 'required|string',
                'deskripsi_konten' => 'required|string',
                'durasi' => 'required|integer',
                'kategori' => 'required|in:Sarapan,Makan Siang,Makan Malam,Cemilan',

                'thumbnail' => 'nullable|file|image',
                'video_tutorial' => 'nullable|file|mimetypes:video/mp4,video/quicktime',

                'bahan' => 'required|array',
                'bahan.*.id_bahan' => 'required|integer',
                'bahan.*.jumlah_bahan' => 'required',
                'bahan.*.satuan_bahan' => 'required|string',

                'langkah' => 'nullable|array',
                'langkah.*.nomor_langkah' => 'required|integer',
                'langkah.*.deskripsi_langkah' => 'required|string',
                'langkah.*.gambar_base64' => 'nullable|string'
            ]);

            $thumbnailPath = $request->file('thumbnail')?->store('thumbnail', 'public');
            $videoPath = $request->file('video_tutorial')?->store('video_tutorial', 'public');

            $kontenResep = KontenResepModel::create([
                'id_user' => $validated['id_user'],
                'judul_konten' => $validated['judul_konten'],
                'deskripsi_konten' => $validated['deskripsi_konten'],
                'durasi' => $validated['durasi'],
                'terbuka_di_level' => $validated['terbuka_di_level'] ?? 0,
                'kategori' => $validated['kategori'],
                'thumbnail' => $thumbnailPath,
                'video_tutorial' => $videoPath,
            ]);

            foreach ($request->input('bahan') as $bahan) {
                BahanResepModel::create([
                    'id_resep' => $kontenResep->id_resep,
                    'id_bahan' => $bahan['id_bahan'],
                    'jumlah_bahan' => $bahan['jumlah_bahan'],
                    'satuan_bahan' => $bahan['satuan_bahan'],
                ]);
            }

            foreach ($request->input('langkah', []) as $index => $langkah) {
                $gambarFile = $request->file("langkah.$index.gambar_langkah");
                $gambarPath = $gambarFile ? $gambarFile->store('gambar_langkah', 'public') : null;

                LangkahLangkahModel::create([
                    'id_resep' => $kontenResep->id_resep,
                    'nomor_langkah' => $index + 1,
                    'deskripsi_langkah' => $langkah['deskripsi_langkah'],
                    'gambar_langkah' => $gambarPath,
                ]);
            }

            DB::commit();
            return response()->json(['message' => 'Konten resep berhasil disimpan'], 201);
        } catch (\Exception $e) {
            DB::rollBack();
            Log::error('Gagal menyimpan konten resep (mobile): ' . $e->getMessage());
            return response()->json(['error' => 'Terjadi kesalahan saat menyimpan konten resep'], 500);
        }
    }

    public function updateStatus(Request $request, $id)
    {
        $validated = $request->validate([
            'status_konten' => 'required|string|in:Draf,Terunggah'
        ]);

        $konten = KontenResepModel::findOrFail($id);
        $konten->status_konten = $validated['status_konten'];
        $konten->save();

        return response()->json(['message' => 'Status konten berhasil diperbarui.'], 200);
    }
}
