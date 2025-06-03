<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\BahanMasakModel;
use Illuminate\Http\Request;

class BahanMasakApiController extends Controller
{
    public function index()
    {
        $data = BahanMasakModel::with('GiziTable')->get();
        return response()->json($data);
    }

    public function show($id)
    {
        $bahan = BahanMasakModel::with('giziTable')->find($id);

        if (!$bahan) {
            return response()->json(['message' => 'Bahan tidak ditemukan'], 404);
        }

        return response()->json($bahan);
    }
}
