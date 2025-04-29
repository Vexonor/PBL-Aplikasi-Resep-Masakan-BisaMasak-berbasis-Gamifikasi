<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class GiziRequest extends FormRequest
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
            "id_bahan" => "nullable|exists:bahan_masak,id_bahan",
            "id_resep" => "nullable|exists:konten_resep,id_resep",
            "nama_gizi" => "required|in:Energi,Karbohidrat,Protein,Lemak,Serat,Gula,Natrium,Kalsium,Zat Besi,Vitamin A,Vitamin B1,Vitamin B2,Vitamin B3,Vitamin B6,Vitamin B12,Vitamin C,Vitamin D,Vitamin E,Vitamin K,Kolesterol",
            "jumlah" => "required|numeric|min:0",
            "satuan" => "required|in:mg,g,µg,kcal,IU,ml,L,%"
        ];
    }

    public function messages()
    {
        return [
            "id_bahan.exists" => "Bahan masak yang dipilih tidak valid.",
            "id_resep.exists" => "Resep yang dipilih tidak valid.",

            "nama_gizi.required" => "Nama gizi wajib diisi.",
            "nama_gizi.in" => "Nama gizi harus salah satu dari pilihan yang tersedia.",

            "jumlah.required" => "Jumlah gizi wajib diisi.",
            "jumlah.numeric" => "Jumlah gizi harus berupa angka.",
            "jumlah.min" => "Jumlah gizi tidak boleh kurang dari 0.",

            "satuan.required" => "Satuan gizi wajib diisi.",
            "satuan.in" => "Satuan gizi harus salah satu dari pilihan yang tersedia.",
        ];
    }
}
