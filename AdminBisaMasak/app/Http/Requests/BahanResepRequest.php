<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class BahanResepRequest extends FormRequest
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
            'nama_bahan' => 'required|exists:bahan_masak,id_bahan',
            'jumlah' => 'required|numeric|min:0.01',
            'satuan' => 'required|in:g,kg,ml,L,sdt,sdm,cup,buah,butir,siung,batang,lembar,potong,sejumput,secukupnya',
        ];
    }

    public function messages()
    {
        return [
            'id_resep.required' => 'ID resep wajib diisi.',
            'id_resep.exists' => 'Resep tidak ditemukan.',
            'id_bahan.required' => 'ID bahan wajib diisi.',
            'id_bahan.exists' => 'Bahan tidak ditemukan.',
            'jumlah.required' => 'Jumlah bahan wajib diisi.',
            'jumlah.numeric' => 'Jumlah bahan harus berupa angka.',
            'jumlah.min' => 'Jumlah bahan harus lebih besar dari 0.',
            'satuan.required' => 'Satuan bahan wajib diisi.',
            'satuan.in' => 'Satuan bahan tidak valid.',
        ];
    }
}
