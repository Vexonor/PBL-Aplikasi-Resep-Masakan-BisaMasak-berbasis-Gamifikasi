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
        $reward = $request->poin_level;
        $pengguna->poin_level += $reward;
        while ($pengguna->poin_level >= $this->getMaxExp($pengguna->level_pengguna)) {
            $pengguna->poin_level -= $this->getMaxExp($pengguna->level_pengguna);
            $pengguna->level_pengguna += 1;
        }
        $pengguna->save();

        return response()->json(['message' => 'Level dan poin berhasil diperbarui', 'pengguna' => $pengguna]);
    }

    private function getMaxExp($level)
    {
        $baseExp = 1000;
        $increment = 500;
        return $baseExp + ($level - 1) * $increment;
    }
}