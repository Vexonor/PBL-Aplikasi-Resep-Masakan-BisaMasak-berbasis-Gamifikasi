<?php

namespace App\Http\Controllers;

use App\Http\Requests\BahanMasakRequest;
use App\Http\Requests\KontenTutorialRequest;
use App\Models\BahanMasakModel;
use App\Models\BahanResepModel;
use App\Models\GiziModel;
use App\Models\KontenResepModel;
use App\Models\LangkahLangkahModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Auth;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;

class KontenTutorialController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $dataCount = $request->input('data_count', 10);
        $dataKontenResep = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->searchByBahanOrJudul($search)->latest();

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
                'thumbnail' => $thumbnailPath,
                'video_tutorial' => $videoPath,
            ]);
            $bahanMasak = BahanMasakModel::all();

            foreach ($request->jumlah_bahan as $index => $jumlah_bahan) {
                if (isset($bahanMasak[$index])) {
                    BahanResepModel::create([
                        'id_resep' => $kontenResep->id_resep,
                        'id_bahan' => $bahanMasak[$index]->id_bahan,
                        'jumlah_bahan' => $jumlah_bahan,
                        'satuan_bahan' => $request->satuan_bahan[$index]
                    ]);
                } else {
                    Log::warning("Bahan masak tidak ditemukan untuk indeks $index.");
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
        //
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        return view('konten-tutorial.edit-konten-page', [
            "title" => "Edit Konten Tutorial"
        ]);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(Request $request, string $id)
    {
        //
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}