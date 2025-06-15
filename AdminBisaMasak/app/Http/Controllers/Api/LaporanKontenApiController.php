<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\LaporanKontenModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Validator;

class LaporanKontenApiController extends Controller
{
    public function storeLaporan(Request $request)
    {
        $validator = Validator::make($request->all(), [
            'id_resep' => 'required|exists:konten_resep,id_resep',
            'deskripsi_laporan' => 'required|string|max:1000',
        ]);

        if ($validator->fails()) {
            return response()->json([
                'message' => 'Validasi gagal',
                'errors' => $validator->errors()
            ], 422);
        }

        $laporan = LaporanKontenModel::create($validator->validated());

        return response()->json([
            'message' => 'Laporan Berhasil Dikirim',
            'data' => $laporan
        ], 201);
    }
}
