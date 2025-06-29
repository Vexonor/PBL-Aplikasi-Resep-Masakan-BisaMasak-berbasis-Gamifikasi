<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\PenggunaModel;
use App\Models\SimpanResepModel;
use App\Models\UserModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Log;

class SimpanResepApiController extends Controller
{
    public function index()
    {
        return SimpanResepModel::with(['PenggunaTable', 'KontenResepTable'])->get();
    }

    public function store(Request $request)
    {
        Log::info('SAVE REQUEST', $request->all());

        try {
            $request->validate([
                'id_user' => 'required|exists:users,id_user',
                'id_resep' => 'required|exists:konten_resep,id_resep',
            ]);

            $sudah = SimpanResepModel::where('id_user', $request->id_user)
                ->where('id_resep', $request->id_resep)
                ->first();

            if ($sudah) {
                return response()->json(['message' => 'Resep sudah disimpan.'], 200);
            }

            $simpan = SimpanResepModel::create([
                'id_user' => $request->id_user,
                'id_resep' => $request->id_resep,
            ]);

            return response()->json(['message' => 'Resep berhasil disimpan.', 'data' => $simpan], 201);
        } catch (\Illuminate\Validation\ValidationException $e) {
            return response()->json(['message' => 'Validasi gagal', 'errors' => $e->errors()], 422);
        } catch (\Exception $e) {
            return response()->json(['message' => 'Server error'], 500);
        }
    }

    public function show($id_user)
    {
        $user = UserModel::with(['savedRecipes' => function ($query) {
            $query->with('KontenResepTable');
        }])->find($id_user);

        if (!$user) {
            return response()->json(['message' => 'Pengguna tidak ditemukan.'], 404);
        }

        $recipes = $user->savedRecipes->map(function ($saved) {
            return [
                'saved_at' => $saved->created_at,
                'recipe' => $saved->KontenResepTable
            ];
        })->filter();

        return response()->json([
            'message' => 'Resep yang disimpan pengguna.',
            'data' => $recipes
        ]);
    }

    public function destroy(Request $request)
    {
        $request->validate([
            'id_user' => 'required|exists:pengguna,id_user',
            'id_resep' => 'required|exists:konten_resep,id_resep',
        ]);

        $deleted = SimpanResepModel::where('id_user', $request->id_user)
            ->where('id_resep', $request->id_resep)
            ->delete();

        if ($deleted) {
            return response()->json(['message' => 'Simpanan berhasil dihapus.']);
        }

        return response()->json(['message' => 'Data simpanan tidak ditemukan.'], 404);
    }

    public function check(Request $request)
    {
        $request->validate([
            'id_user' => 'required|exists:pengguna,id_user',
            'id_resep' => 'required|exists:konten_resep,id_resep',
        ]);

        $exists = SimpanResepModel::where('id_user', $request->id_user)
            ->where('id_resep', $request->id_resep)
            ->exists();

        return response()->json([
            'sudah_disimpan' => $exists
        ]);
    }
}
