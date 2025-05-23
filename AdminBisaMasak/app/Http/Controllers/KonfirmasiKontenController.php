<?php

namespace App\Http\Controllers;

use App\Models\BahanMasakModel;
use App\Models\KontenResepModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;

class KonfirmasiKontenController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $dataCount = $request->input('data_count', 10);
        $dataKontenResep = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->where('status_konten', 'Draf')->judulKonten($search)->latest();

        $data = $dataKontenResep->paginate($dataCount);

        return view('konfirmasi-konten.konfirmasi-konten-page', [
            "title" => "Konfirmasi Konten",
            "dataResep" => $data
        ]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        //
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(Request $request)
    {
        //
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->findOrFail($id);
        $dataBahanMasak = BahanMasakModel::all();
        return view('konfirmasi-konten.detail-konten-page', [
            "title" => "Detail Konten Resep",
            "dataResep" => $data,
            "dataBahanMasak" => $dataBahanMasak
        ]);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        //
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(string $id)
    {
        DB::beginTransaction();
        try {
            $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable')->findOrFail($id);

            $data->update([
                'status_konten' => 'Terunggah'
            ]);

            DB::commit();
            return redirect()->back()->with('success', 'Konten Resep berhasil diunggah!');
        } catch (\Exception $e) {
            DB::rollBack();
            Log::error('Gagal mengunggah konten resep: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Konten Resep gagal diunggah!');
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        DB::beginTransaction();
        try {
            $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable')->findOrFail($id);

            $data->update([
                'status_konten' => 'Terblokir'
            ]);

            DB::commit();
            return redirect()->back()->with('success', 'Konten Resep berhasil diblokir!');
        } catch (\Exception $e) {
            DB::rollBack();
            Log::error('Gagal memblokir konten resep: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Konten Resep gagal diblokir!');
        }
    }
}
