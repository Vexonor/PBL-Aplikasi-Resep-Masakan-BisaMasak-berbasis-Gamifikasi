<?php

namespace App\Http\Controllers\Api;

use App\Http\Controllers\Controller;
use App\Models\UserModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Validator;

class ProfileApiController extends Controller
{
    public function updateProfile(Request $request, $id_user)
    {
        $user = UserModel::find($id_user);

        if (!$user) {
            return response()->json(['error' => 'User not found'], 404);
        }

        $validator = Validator::make($request->all(), [
            'nama' => 'sometimes|string|max:255',
            'tanggal_lahir' => 'nullable|date',
            'jenis_kelamin' => 'nullable|in:Laki-laki,Perempuan',
            'foto_profil' => 'nullable|image|mimes:jpg,jpeg,png|max:2048',
            'email' => 'sometimes|email|unique:users,email,' . $user->id_user . ',id_user',
            'password' => 'nullable|string|min:8'
        ]);

        if ($validator->fails()) {
            return response()->json(['error' => $validator->errors()], 422);
        }

        if ($request->has('nama')) $user->nama = $request->nama;
        if ($request->has('tanggal_lahir')) $user->tanggal_lahir = $request->tanggal_lahir;
        if ($request->has('jenis_kelamin')) $user->jenis_kelamin = $request->jenis_kelamin;
        if ($request->has('email')) $user->email = $request->email;

        if ($request->filled('password')) {
            $user->password = Hash::make($request->password);
        }

        if ($request->hasFile('foto_profil')) {
            $file = $request->file('foto_profil');
            $filename = uniqid() . '_' . $file->getClientOriginalName();
            $file->storeAs('foto_profil', $filename, 'public');
            $user->foto_profil = 'foto_profil/' . $filename;
        }

        $user->save();

        return response()->json([
            'message' => 'Profile updated successfully',
            'user' => $user
        ]);
    }
}
