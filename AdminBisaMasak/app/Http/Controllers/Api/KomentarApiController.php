<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\KomentarModel;
use Illuminate\Http\Request;

class KomentarApiController extends Controller
{
    public function index()
    {
        return response()->json(KomentarModel::with(['UserTable', 'KontenResepTable'])->get());
    }

    public function getByRecipeId($id_resep)
    {
        $komentar = KomentarModel::with(['UserTable', 'KontenResepTable'])
            ->where('id_resep', $id_resep)
            ->get();

        return response()->json($komentar);
    }


    public function store(Request $request)
    {
        $validated = $request->validate([
            'id_user' => 'required|exists:users,id_user',
            'id_resep' => 'required|exists:konten_resep,id_resep',
            'isi_komentar' => 'required|string'
        ]);

        $komentar = KomentarModel::create($validated);
        return response()->json($komentar, 201);
    }

    public function destroy($id)
    {
        $komentar = KomentarModel::find($id);
        if (!$komentar) {
            return response()->json(['message' => 'Komentar not found'], 404);
        }

        $komentar->delete();
        return response()->json(['message' => 'Komentar deleted successfully']);
    }
}