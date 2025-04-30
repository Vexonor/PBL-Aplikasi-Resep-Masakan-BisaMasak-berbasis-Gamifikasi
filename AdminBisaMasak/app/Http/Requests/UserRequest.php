<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class UserRequest extends FormRequest
{
    /**
     * Determine if the user is authorized to make this request.
     */
    public function authorize(): bool
    {
        return true;
    }

    /**
     * Get the validation rules that apply to the request.
     *
     * @return array<string, \Illuminate\Contracts\Validation\ValidationRule|array<mixed>|string>
     */
    public function rules(): array
    {
        return [
            'nama' => 'required|string|max:255',
            'tanggal_lahir' => 'nullable|date',
            'jenis_kelamin' => 'nullable|in:Laki-laki,Perempuan',
            'foto_profil' => 'nullable|image|mimes:jpg,jpeg,png|max:5012',
            'email' => 'required|email|unique:users,email',
            'password' => 'string|min:8',
            'peran' => 'in:Admin,Pengguna',
            'peran_admin' => 'required|in:Master Admin,Admin'
        ];
    }

    public function messages(): array
    {
        return [
            'nama.required' => 'Nama wajib diisi.',
            'nama.string' => 'Nama harus berupa teks.',
            'nama.max' => 'Nama maksimal 255 karakter.',

            'tanggal_lahir.date' => 'Tanggal lahir harus berupa tanggal yang valid.',

            'jenis_kelamin.in' => 'Jenis kelamin harus "Laki-laki" atau "Perempuan".',

            'foto_profil.image' => 'File harus berupa gambar.',
            'foto_profil.mimes' => 'Format gambar harus jpg, jpeg, atau png.',
            'foto_profil.max' => 'Ukuran gambar maksimal 5MB.',

            'email.required' => 'Email wajib diisi.',
            'email.email' => 'Format email tidak valid.',
            'email.unique' => 'Email sudah terdaftar.',

            'password.required' => 'Password wajib diisi.',
            'password.string' => 'Password harus berupa teks.',
            'password.min' => 'Password minimal terdiri dari 8 karakter.',

            'peran.required' => 'Peran wajib dipilih.',
            'peran.in' => 'Peran hanya boleh "Admin" atau "Pengguna".',

            'peran_admin.required' => 'Peran wajib dipilih.',
            'peran_admin.in' => 'Peran hanya boleh "Master Admin" atau "Admin".',
        ];
    }
}
