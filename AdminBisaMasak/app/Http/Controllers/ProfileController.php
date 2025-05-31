<?php

namespace App\Http\Controllers;

use App\Models\UserModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;

class ProfileController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index()
    {
        return view('profile.profile-page', [
            "title" => "Profile Pengguna",
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
    public function store(Request $request) {}

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
        $tipe = $request->input('tipe_form');
        DB::beginTransaction();
        try {
            $user = UserModel::findOrFail($id);

            if ($tipe === 'profil') {
                $request->validate([
                    'nama' => 'required|string|max:255',
                    'tanggal_lahir' => 'required|date',
                    'email' => 'required|email',
                    'jenis_kelamin' => 'required|in:Laki-laki,Perempuan',
                ]);

                $user->update([
                    'nama' => $request->nama,
                    'tanggal_lahir' => $request->tanggal_lahir,
                    'email' => $request->email,
                    'jenis_kelamin' => $request->jenis_kelamin,
                ]);
            } elseif ($tipe === 'password') {
                $request->validate([
                    'password' => 'required|min:8',
                ]);

                $user->update([
                    'password' => Hash::make($request->password),
                ]);
            } elseif ($tipe === 'foto') {
                $request->validate([
                    'foto_profil' => 'required|image|mimes:jpg,jpeg,png|max:2048',
                ]);

                $path = $request->file('foto_profil')->store('foto_profil', 'public');

                if ($user->foto_profil) {
                    Storage::disk('public')->delete($user->foto_profil);
                }

                $user->update([
                    'foto_profil' => $path,
                ]);
            }

            DB::commit();
            return back()->with('success', 'Data berhasil diperbarui.');
        } catch (\Exception $e) {
            return back()->with('error', 'Terjadi kesalahan saat memperbarui data.');
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
