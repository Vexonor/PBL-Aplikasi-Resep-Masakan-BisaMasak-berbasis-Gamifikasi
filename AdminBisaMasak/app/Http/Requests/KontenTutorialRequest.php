<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class KontenTutorialRequest extends FormRequest
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
            // Recipe Content
            'judul_konten' => 'required|string|max:255',
            'deskripsi_konten' => 'required|string',
            'thumbnail' => 'required|image|mimes:jpg,jpeg,png|max:5012',
            'video_tutorial' => 'nullable|string|max:255',
            'status_konten' => 'in:Draf,Terunggah,Terblokir',

            // Ingredient
            'jumlah_bahan' => 'required|min:0.01',
            'satuan_bahan' => 'required',

            // Nutrition
            "id_bahan" => "nullable|exists:bahan_masak,id_bahan",
            "id_resep" => "nullable|exists:konten_resep,id_resep",
            "nama_gizi" => "required",
            "jumlah" => "required|min:0",
            "satuan" => "required",

            // Step
            'nomor_langkah' => 'required|min:1',
            'deskripsi_langkah' => 'required',
            'gambar_langkah' => 'required|max:5012',
        ];
    }

    public function messages()
    {
        return [
            // Recipe Content
            'id_user.exists' => 'User tidak ditemukan.',
            'judul_konten.required' => 'Judul konten wajib diisi.',
            'judul_konten.string' => 'Judul konten harus berupa teks.',
            'judul_konten.max' => 'Judul konten maksimal 255 karakter.',
            'deskripsi_konten.required' => 'Deskripsi konten wajib diisi.',
            'deskripsi_konten.string' => 'Deskripsi konten harus berupa teks.',
            'thumbnail.required' => 'Thumbnail wajib diisi.',
            'thumbnail.max' => 'Thumbnail maksimal 255 karakter.',
            'video_tutorial.max' => 'Video tutorial maksimal 255 karakter.',
            'status_konten.in' => 'Status konten tidak valid.',

            // Ingredient
            'id_resep.required' => 'ID resep wajib diisi.',
            'id_resep.exists' => 'Resep tidak ditemukan.',
            'id_bahan.required' => 'ID bahan wajib diisi.',
            'id_bahan.exists' => 'Bahan tidak ditemukan.',
            'jumlah_bahan.required' => 'Jumlah bahan wajib diisi.',
            'jumlah_bahan.numeric' => 'Jumlah bahan harus berupa angka.',
            'jumlah_bahan.min' => 'Jumlah bahan harus lebih besar dari 0.',
            'satuan_bahan.required' => 'Satuan bahan wajib diisi.',
            'satuan_bahan.in' => 'Satuan bahan tidak valid.',

            // Recipe
            "nama_gizi.required" => "Nama gizi wajib diisi.",
            "nama_gizi.in" => "Nama gizi harus salah satu dari pilihan yang tersedia.",

            "jumlah.required" => "Jumlah gizi wajib diisi.",
            "jumlah.numeric" => "Jumlah gizi harus berupa angka.",
            "jumlah.min" => "Jumlah gizi tidak boleh kurang dari 0.",

            "satuan.required" => "Satuan gizi wajib diisi.",
            "satuan.in" => "Satuan gizi harus salah satu dari pilihan yang tersedia.",

            // Step
            'nomor_langkah.required' => 'Nomor langkah wajib diisi.',
            'nomor_langkah.integer' => 'Nomor langkah harus berupa angka.',
            'nomor_langkah.min' => 'Nomor langkah harus lebih besar dari atau sama dengan 1.',
            'deskripsi_langkah.required' => 'Deskripsi langkah wajib diisi.',
            'deskripsi_langkah.string' => 'Deskripsi langkah harus berupa teks.',
            'gambar_langkah.required' => 'Gambar langkah wajib diisi.',
            'gambar_langkah.string' => 'Gambar langkah harus berupa teks.',
            'gambar_langkah.max' => 'Gambar langkah maksimal 255 karakter.',
        ];
    }
}