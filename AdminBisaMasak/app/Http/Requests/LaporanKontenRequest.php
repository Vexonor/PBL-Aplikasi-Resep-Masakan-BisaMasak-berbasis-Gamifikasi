<?php

namespace App\Http\Requests;

use Illuminate\Foundation\Http\FormRequest;

class LaporanKontenRequest extends FormRequest
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
            'id_resep' => 'required|integer|exists:konten_resep,id_resep',
            'deskripsi_laporan' => 'required|string',
        ];
    }

    public function messages()
    {
        return [
            'deskripsi_laporan.required' => 'Deskripsi langkah wajib diisi.',
            'deskripsi_laporan.string' => 'Deskripsi langkah harus berupa teks.',
        ];
    }
}
