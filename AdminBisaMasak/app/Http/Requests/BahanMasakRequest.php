<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class BahanMasakRequest extends FormRequest
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
            "nama_bahan" => "required|string|max:255",
            "deskripsi_bahan" => "required|string",
            "gambar_bahan" => [
                "required",
                "url",
                function ($attribute, $value, $fail) {
                    if (!preg_match('/\.(jpg|jpeg|png|webp)$/i', $value)) {
                        $fail('Gambar ' . $attribute . ' harus memiliki url yang valid.');
                    }
                },
            ],
        ];
    }

    public function messages()
    {
        return [
            "nama_bahan.required" => "Nama bahan Wajib Diisi",
            "nama_bahan.string" => "Nama Bahan Harus Berupa Teks",
            "nama_bahan.max" => "Nama Bahan Tidak Boleh Lebih Dari 255 Karakter",

            "deskripsi_bahan.required" => "Deskripsi Bahan Wajib Diisi",
            "deskripsi_bahan.string" => "Deskripsi Bahan Harus Berupa Teks",

            "gambar_bahan.required" => "Gambar Bahan Wajib Diunggah",
            "gambar_bahan.image" => "File yang Diunggah Harus Berupa Gambar",
            "gambar_bahan.mimes" => "Format Gambar yang Diizinkan: jpeg, png, jpg, webp",
            "gambar_bahan.max" => "Ukuran Gambar Maksimal 5MB",

            "terbuka_di_level.required" => "Level Pembukaan Wajib Diisi",
            "terbuka_di_level.integer" => "Level Pembukaan Harus Berupa Angka",
            "terbuka_di_level.min" => "Level Pembukaan Minimal 1"
        ];
    }
}
