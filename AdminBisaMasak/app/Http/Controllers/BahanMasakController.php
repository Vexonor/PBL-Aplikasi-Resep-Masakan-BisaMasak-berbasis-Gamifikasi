<?php

namespace App\Http\Controllers;

use App\Http\Requests\BahanMasakRequest;
use App\Models\BahanMasakModel;
use App\Models\GiziModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Storage;

class BahanMasakController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $dataCount = $request->input('data_count', 10);
        $dataBahanMasak = BahanMasakModel::with('GiziTable')->bahanMasak($search)->latest();

        $data = $dataBahanMasak->paginate($dataCount);

        return view('bahan-masak.bahan-masak-page', [
            "title" => "Bahan Masak",
            "dataBahanMasak" => $data
        ]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('bahan-masak.tambah-bahan-page', [
            "title" => "Tambah Bahan Masak"
        ]);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(BahanMasakRequest $request)
    {
        DB::beginTransaction();

        try {

            $bahan = BahanMasakModel::create([
                'nama_bahan' => $request->nama_bahan,
                'deskripsi_bahan' => $request->deskripsi_bahan,
                'gambar_bahan' => $request->gambar_bahan,
                'terbuka_di_level' => $request->terbuka_di_level
            ]);

            foreach ($request->nama_gizi as $index => $gizi) {
                GiziModel::create([
                    'id_bahan' => $bahan->id_bahan,
                    'nama_gizi' => $gizi,
                    'jumlah' => $request->jumlah[$index],
                    'satuan' => $request->satuan[$index]
                ]);
            }

            DB::commit();
            return redirect()->route('bahan-masak.index')->with('success', 'Bahan masak berhasil ditambahkan!');
        } catch (\Exception $e) {

            DB::rollBack();
            Log::error('Gagal menambahkan bahan masak: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Bahan masak gagal ditambahkan!');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $dataBahanMasak = BahanMasakModel::with('GiziTable')->findOrFail($id);
        return view('bahan-masak.detail-bahan-page', [
            "title" => "Detail Bahan Masak",
            "dataBahanMasak" => $dataBahanMasak
        ]);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $dataBahanMasak = BahanMasakModel::with('GiziTable')->findOrFail($id);
        return view('bahan-masak.edit-bahan-page', [
            "title" => "Edit Bahan Masak",
            "dataBahanMasak" => $dataBahanMasak
        ]);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(BahanMasakRequest $request, string $id)
    {
        DB::beginTransaction();
        try {
            $bahan = BahanMasakModel::with('GiziTable')->findOrFail($id);
            $bahan->update([
                'nama_bahan' => $request->nama_bahan,
                'deskripsi_bahan' => $request->deskripsi_bahan,
                'gambar_bahan' => $request->gambar_bahan,
                'terbuka_di_level' => $request->terbuka_di_level
            ]);

            $bahan->GiziTable()->delete();

            foreach ($request->nama_gizi as $index => $namaGizi) {
                $bahan->GiziTable()->create([
                    'nama_gizi' => $namaGizi,
                    'jumlah' => $request->jumlah[$index],
                    'satuan' => $request->satuan[$index]
                ]);
            }

            DB::commit();
            return redirect()->route('bahan-masak.index')->with('success', 'Bahan masak berhasil diedit!');
        } catch (\Exception $e) {

            DB::rollBack();
            Log::error('Gagal mengedit bahan masak: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Bahan masak gagal diedit!');
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $bahan = BahanMasakModel::findOrFail($id);

        if ($bahan->gambar_bahan) {
            Storage::disk('public')->delete($bahan->gambar_bahan);
        }

        $bahanDelete = $bahan->delete();

        if ($bahanDelete) {
            return redirect()->back()->with('success', 'Data bahan masak berhasil dihapus!');
        } else {
            return redirect()->back()->with('error', 'Data bahan masak gagal dihapus!');
        }
    }
}
