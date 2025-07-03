<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\PenggunaModel;
use Illuminate\Http\Request;

class LevelingApiController extends Controller
{
    public function updateLevel(Request $request, $id_user)
    {
        $request->validate([
            'poin_level' => 'required|integer',
            'level_pengguna' => 'required|integer',
        ]);

        $pengguna = PenggunaModel::where('id_user', $id_user)->firstOrFail();
        $pengguna->poin_level = $request->poin_level;
        $pengguna->level_pengguna = $request->level_pengguna;
        $pengguna->save();

        return response()->json(['message' => 'Level dan poin berhasil diperbarui', 'pengguna' => $pengguna]);
    }
}
