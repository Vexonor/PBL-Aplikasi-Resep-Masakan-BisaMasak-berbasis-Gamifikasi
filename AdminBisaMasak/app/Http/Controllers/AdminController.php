<?php

namespace App\Http\Controllers;

use App\Http\Requests\UpdateUserRequest;
use App\Http\Requests\UserRequest;
use App\Models\AdminModel;
use App\Models\UserModel;
use Illuminate\Http\Request;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Facades\Log;
use Illuminate\Support\Facades\Storage;
use Illuminate\Validation\Rule;

class AdminController extends Controller
{
    /**
     * Display a listing of the resource.
     */
    public function index(Request $request)
    {
        $search = $request->input('search');
        $dataCount = $request->input('data_count', 10);
        $dataAdmin = AdminModel::with('UserTable')->admin($search)->latest();

        $data = $dataAdmin->paginate($dataCount);
        return view('admin.admin-page', [
            "title" => "Admin",
            "dataAdmin" => $data
        ]);
    }

    /**
     * Show the form for creating a new resource.
     */
    public function create()
    {
        return view('admin.tambah-admin-page', [
            "title" => "Tambah Admin"
        ]);
    }

    /**
     * Store a newly created resource in storage.
     */
    public function store(UserRequest $request)
    {
        DB::beginTransaction();
        try {
            if ($request->hasFile('foto_profil')) {
                $foto_profil = $request->file('foto_profil')->store('image/foto_profil', 'public');
            }

            $user = UserModel::create([
                'nama' => $request->nama,
                'tanggal_lahir' => $request->tanggal_lahir,
                'jenis_kelamin' => $request->jenis_kelamin,
                'foto_profil' => $foto_profil ?? null,
                'email' => $request->email,
                'password' => bcrypt("Password123"),
                'peran' => "Admin"
            ]);

            AdminModel::create([
                'id_user' => $user->id_user,
                'peran_admin' => $request->peran_admin
            ]);

            DB::commit();
            return redirect()->route('admin.index')->with('success', 'Admin berhasil ditambahkan!');
        } catch (\Exception $e) {

            DB::rollBack();
            Log::error('Gagal menambahkan admin: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Admin gagal ditambahkan!');
        }
    }

    /**
     * Display the specified resource.
     */
    public function show(string $id)
    {
        $data = AdminModel::with('UserTable')->findOrFail($id);
        return view('admin.detail-admin-page', [
            "title" => "Detail Admin",
            "dataAdmin" => $data
        ]);
    }

    /**
     * Show the form for editing the specified resource.
     */
    public function edit(string $id)
    {
        $data = AdminModel::with('UserTable')->findOrFail($id);
        return view('admin.edit-admin-page', [
            "title" => "Edit Admin",
            "dataAdmin" => $data
        ]);
    }

    /**
     * Update the specified resource in storage.
     */
    public function update(UpdateUserRequest $request, string $id)
    {
        DB::beginTransaction();
        try {
            $admin = AdminModel::with('UserTable')->findOrFail($id);
            $user = $admin->UserTable;

            if ($request->hasFile('foto_profil')) {
                if ($user->foto_profil) {
                    Storage::disk('public')->delete($user->foto_profil);
                }
                $foto_profil = $request->file('foto_profil')->store('image/foto_profil', 'public');
                $user->foto_profil = $foto_profil;
            }

            $user->update([
                'nama' => $request->nama,
                'tanggal_lahir' => $request->tanggal_lahir,
                'jenis_kelamin' => $request->jenis_kelamin,
                'email' => $request->email,
                'password' => $request->filled('password') ? Hash::make($request->password) : $user->password,
                'peran' => "Admin"
            ]);

            $admin->update([
                'peran_admin' => $request->peran_admin
            ]);

            DB::commit();
            return redirect()->route('admin.index')->with('success', 'Admin berhasil diedit!');
        } catch (\Exception $e) {

            DB::rollBack();
            Log::error('Gagal mengedit admin: ' . $e->getMessage());
            return redirect()->back()->with('error', 'Admin gagal diedit!');
        }
    }

    /**
     * Remove the specified resource from storage.
     */
    public function destroy(string $id)
    {
        $admin = AdminModel::with('UserTable')->findOrFail($id);

        if ($admin->foto_profil) {
            Storage::disk('public')->delete($admin->foto_profil);
        }

        $adminDelete = $admin->delete();

        if ($adminDelete) {
            return redirect()->back()->with('success', 'Data admin berhasil dihapus!');
        } else {
            return redirect()->back()->with('error', 'Data admin gagal dihapus!');
        }
    }
}
