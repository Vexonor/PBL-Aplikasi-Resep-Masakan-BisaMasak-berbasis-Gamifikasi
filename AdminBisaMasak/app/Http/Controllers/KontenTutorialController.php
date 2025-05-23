<?php

namespace App\Http\Controllers;

use App\Models\BahanMasakModel;
use App\Models\BahanResepModel;
use App\Models\GiziModel;
use App\Models\KontenResepModel;
use App\Models\LangkahLangkahModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;

class KontenTutorialController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $dataCount = $request->input('data_count', 10);
        $dataKontenResep = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->judulKonten($search)->latest();

        $data = $dataKontenResep->paginate($dataCount);

        return view('konten-tutorial.konten-tutorial-page', [
            "title" => "Konten Tutorial",
            "dataResep" => $data
        ]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        $dataBahanMasak = BahanMasakModel::all();
        return view('konten-tutorial.tambah-konten-page', [
            "title" => "Tambah Konten Tutorial",
            "dataBahanMasak" => $dataBahanMasak
        ]);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        DB::beginTransaction();

        try {
            $thumbnailPath = null;
            $videoPath = null;

            if ($request->hasFile('thumbnail') && $request->file('thumbnail')->isValid()) {
                $thumbnailPath = $request->file('thumbnail')->store('thumbnail', 'public');
            }

            if ($request->hasFile('video_tutorial') && $request->file('video_tutorial')->isValid()) {
                $videoPath = $request->file('video_tutorial')->store('video_tutorial', 'public');
            }

            $kontenResep = KontenResepModel::create([
                'id_user' => Auth::user()->id_user,
                'judul_konten' => $request->judul_konten,
                'deskripsi_konten' => $request->deskripsi_konten,
                'terbuka_di_level' => $request->terbuka_di_level,
                'thumbnail' => $thumbnailPath,
                'video_tutorial' => $videoPath,
            ]);

            foreach ($request->id_bahan as $index => $id_bahan) {
                if (isset($request->jumlah_bahan[$index]) && isset($request->satuan_bahan[$index])) {
                    BahanResepModel::create([
                        'id_resep' => $kontenResep->id_resep,
                        'id_bahan' => $id_bahan,
                        'jumlah_bahan' => $request->jumlah_bahan[$index],
                        'satuan_bahan' => $request->satuan_bahan[$index]
                    ]);
                } else {
                    Log::warning("Data tidak lengkap untuk bahan dengan id $id_bahan pada indeks $index.");
                }
            }

            foreach ($request->nama_gizi as $index => $gizi) {
                GiziModel::create([
                    'id_resep' => $kontenResep->id_resep,
                    'nama_gizi' => $gizi,
                    'jumlah' => $request->jumlah[$index],
                    'satuan' => $request->satuan[$index]
                ]);
            }

            if ($request->has('nomor_langkah') && $request->has('deskripsi_langkah') && $request->has('gambar_langkah')) {
                foreach ($request->nomor_langkah as $index => $nomor) {
                    $gambarPath = null;

                    if (isset($request->gambar_langkah[$index]) && $request->gambar_langkah[$index]->isValid()) {
                        $gambarPath = $request->gambar_langkah[$index]->store('gambar_langkah', 'public');
                    }

                    LangkahLangkahModel::create([
                        'id_resep' => $kontenResep->id_resep,
                        'nomor_langkah' => $nomor,
                        'deskripsi_langkah' => $request->deskripsi_langkah[$index],
                        'gambar_langkah' => $gambarPath
                    ]);
                }
            }


            DB::commit();
            return redirect()->route('konten-tutorial.index')->with('success', 'Konten resep berhasil ditambahkan!');
        } catch (\Exception $e) {

            DB::rollBack();
            Log::error('Gagal menambahkan konten resep: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Konten resep gagal ditambahkan!');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->findOrFail($id);
        $dataBahanMasak = BahanMasakModel::all();
        return view('konten-tutorial.detail-konten-page', [
            "title" => "Detail Konten Tutorial",
            "dataResep" => $data,
            "dataBahanMasak" => $dataBahanMasak
        ]);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->findOrFail($id);
        $dataBahanMasak = BahanMasakModel::all();
        return view('konten-tutorial.edit-konten-page', [
            "title" => "Edit Konten Tutorial",
            "dataResep" => $data,
            "dataBahanMasak" => $dataBahanMasak
        ]);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        DB::beginTransaction();
        try {
            $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable')->findOrFail($id);

            $thumbnail = $data->thumbnail;
            $video = $data->video_tutorial;

            // Thumbnail
            if ($request->hasFile('thumbnail') && $request->file('thumbnail')->isValid()) {
                if ($data->thumbnail) {
                    Storage::disk('public')->delete($data->thumbnail);
                }
                $thumbnail = $request->file('thumbnail')->store('thumbnail', 'public');
            }

            // Video
            if ($request->hasFile('video_tutorial') && $request->file('video_tutorial')->isValid()) {
                if ($data->video_tutorial) {
                    Storage::disk('public')->delete($data->video_tutorial);
                }
                $video = $request->file('video_tutorial')->store('video_tutorial', 'public');
            }

            // Update Konten Resep
            $data->update([
                'judul_konten' => $request->judul_konten,
                'deskripsi_konten' => $request->deskripsi_konten,
                'terbuka_di_level' => $request->terbuka_di_level,
                'thumbnail' => $thumbnail,
                'video_tutorial' => $video,
            ]);

            // Update Bahan Resep
            if ($request->has('id_bahan') && is_array($request->id_bahan)) {
                $data->BahanResepTable()->delete();

                foreach ($request->id_bahan as $index => $id_bahan) {
                    BahanResepModel::create([
                        'id_resep' => $data->id_resep,
                        'id_bahan' => $id_bahan,
                        'jumlah_bahan' => $request->jumlah_bahan[$index],
                        'satuan_bahan' => $request->satuan_bahan[$index],
                    ]);
                }
            }

            // Update Gizi
            if ($request->has('nama_gizi') && is_array($request->nama_gizi)) {
                $data->GiziTable()->delete();

                foreach ($request->nama_gizi as $index => $nama_gizi) {
                    if (isset($request->jumlah[$index]) && isset($request->satuan[$index])) {
                        GiziModel::create([
                            'id_resep' => $data->id_resep,
                            'nama_gizi' => $nama_gizi,
                            'jumlah' => $request->jumlah[$index],
                            'satuan' => $request->satuan[$index]
                        ]);
                    }
                }
            }

            // Update Langkah-langkah
            $existingSteps = $data->LangkahLangkahTable->keyBy('nomor_langkah');
            $inputStepNumbers = [];

            if (
                $request->has('nomor_langkah') &&
                $request->has('deskripsi_langkah') &&
                is_array($request->nomor_langkah)
            ) {
                foreach ($request->nomor_langkah as $index => $stepNumber) {
                    $inputStepNumbers[] = $stepNumber;

                    $existingStep = $existingSteps->get($stepNumber);
                    $description = $request->deskripsi_langkah[$index] ?? '';
                    $uploadedFile = $request->gambar_langkah[$index] ?? null;

                    $isValidUpload = $uploadedFile instanceof \Illuminate\Http\UploadedFile && $uploadedFile->isValid();
                    $newImagePath = null;

                    if ($isValidUpload) {
                        if ($existingStep && $existingStep->gambar_langkah) {
                            Storage::disk('public')->delete($existingStep->gambar_langkah);
                        }
                        $newImagePath = $uploadedFile->store('gambar_langkah', 'public');
                    }

                    if ($existingStep) {
                        $existingStep->update([
                            'deskripsi_langkah' => $description,
                            'gambar_langkah' => $newImagePath ?? $existingStep->gambar_langkah,
                        ]);
                    } else {
                        $data->LangkahLangkahTable()->create([
                            'nomor_langkah' => $stepNumber,
                            'deskripsi_langkah' => $description,
                            'gambar_langkah' => $newImagePath,
                        ]);
                    }
                }

                $data->LangkahLangkahTable()
                    ->whereNotIn('nomor_langkah', $inputStepNumbers)
                    ->delete();
            } else {
                $data->LangkahLangkahTable()->delete();
            }

            DB::commit();
            return redirect()->route('konten-tutorial.index')->with('success', 'Konten Resep berhasil diedit!');
        } catch (\Exception $e) {
            DB::rollBack();
            Log::error('Gagal mengedit konten resep: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Konten Resep gagal diedit!');
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        DB::beginTransaction();

        try {
            $kontenResep = KontenResepModel::findOrFail($id);

            BahanResepModel::where('id_resep', $id)->delete();

            GiziModel::where('id_resep', $id)->delete();

            $langkahLangkah = LangkahLangkahModel::where('id_resep', $id)->get();

            foreach ($langkahLangkah as $langkah) {
                if ($langkah->gambar_langkah) {
                    Storage::disk('public')->delete($langkah->gambar_langkah);
                }
            }
            LangkahLangkahModel::where('id_resep', $id)->delete();

            if ($kontenResep->thumbnail) {
                Storage::disk('public')->delete($kontenResep->thumbnail);
            }

            if ($kontenResep->video_tutorial) {
                Storage::disk('public')->delete($kontenResep->video_tutorial);
            }

            $kontenResep->delete();

            DB::commit();
            return redirect()->route('konten-tutorial.index')->with('success', 'Konten resep berhasil dihapus!');
        } catch (\Exception $e) {
            DB::rollBack();
            Log::error('Gagal menghapus konten resep: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Konten resep gagal dihapus!');
        }
    }
}