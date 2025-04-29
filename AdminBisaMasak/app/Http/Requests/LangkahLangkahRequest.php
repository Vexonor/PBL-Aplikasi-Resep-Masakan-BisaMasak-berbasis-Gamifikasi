<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class LangkahLangkahRequest extends FormRequest
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
            'id_resep' => 'required|exists:konten_resep,id_resep',
            'nomor_langkah' => 'required|integer|min:1',
            'deskripsi_langkah' => 'required|string',
            'gambar_langkah' => 'required|string|max:255',
        ];
    }

    public function messages()
    {
        return [
            'id_resep.required' => 'ID resep wajib diisi.',
            'id_resep.exists' => 'Resep tidak ditemukan.',
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
