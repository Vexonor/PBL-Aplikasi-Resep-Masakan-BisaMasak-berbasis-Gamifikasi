<?php

namespace App\Http\Controllers;

use App\Http\Requests\LaporanKontenRequest;
use App\Models\BahanMasakModel;
use App\Models\KontenResepModel;
use App\Models\LaporanKontenModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Log;

class LaporanKontenController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $dataCount = $request->input('data_count', 10);

        $dataLaporanKonten = LaporanKontenModel::with('KontenResepTable')
            ->select('laporan_konten.*')
            ->join(DB::raw('(SELECT id_resep, MIN(created_at) as oldest_date 
                        FROM laporan_konten 
                        GROUP BY id_resep) as oldest'), function ($join) {
                $join->on('laporan_konten.id_resep', '=', 'oldest.id_resep')
                    ->on('laporan_konten.created_at', '=', 'oldest.oldest_date');
            })
            ->when($search, function ($query) use ($search) {
                return $query->whereHas('KontenResepTable', function ($q) use ($search) {
                    $q->where('judul_konten', 'LIKE', '%' . $search . '%');
                });
            })
            ->latest('laporan_konten.created_at');

        $data = $dataLaporanKonten->paginate($dataCount);

        return view('laporan-konten.laporan-konten-page', [
            "title" => "Laporan Konten",
            "dataLaporan" => $data
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
        DB::beginTransaction();
        try {
            LaporanKontenModel::create([
                'id_resep' => $request->id_resep,
                'deskripsi_laporan' => $request->deskripsi_laporan
            ]);

            DB::commit();
            return redirect()->back()->with('success', 'Konten berhasil dilaporkan!');
        } catch (\Exception $e) {

            DB::rollBack();
            Log::error('Gagal melaporkan konten: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Konten gagal dilaporkan!');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $data = KontenResepModel::with('BahanResepTable', 'GiziTable', 'LangkahLangkahTable',)->findOrFail($id);
        $dataBahanMasak = BahanMasakModel::all();

        return view('laporan-konten.detail-konten-page', [
            "title" => "Detail Konten Laporan",
            "dataResep" => $data,
            "dataBahanMasak" => $dataBahanMasak,
            "resepId" => $id
        ]);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $laporanKonten = LaporanKontenModel::with('KontenResepTable')->where('id_resep', $id)->get();

        return view('laporan-konten.detail-laporan-page', [
            "title" => "Detail Laporan",
            "laporanKonten" => $laporanKonten,
            "resepId" => $id
        ]);
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

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        //
    }
}
