<?php

namespace App\Http\Controllers;

use App\Models\BahanMasakModel;
use App\Models\KontenResepModel;
use App\Models\LaporanKontenModel;
use Illuminate\Http\Request;

class DashboardController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        $dataKontenResep = KontenResepModel::count();
        $dataBahanMasak = BahanMasakModel::count();
        $dataLaporan = LaporanKontenModel::count();

        return view('dashboard.dashboard-page', [
            "title" => "Dashboard",
            "dataKontenResep" => $dataKontenResep,
            "dataBahanMasak" => $dataBahanMasak,
            "dataLaporan" => $dataLaporan
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
        //
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
