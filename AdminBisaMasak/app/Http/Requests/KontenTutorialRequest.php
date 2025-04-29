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
            'id_user' => 'required|exists:users,id_user',
            'judul_konten' => 'required|string|max:255',
            'deskripsi_konten' => 'required|string',
            'thumbnail' => 'required|string',
            'video_tutorial' => 'nullable|string|max:255',
            'status_konten' => 'in:Draf,Terunggah,Terblokir',
        ];
    }

    public function messages()
    {
        return [
            'id_user.exists' => 'User tidak ditemukan.',
            'judul_konten.required' => 'Judul konten wajib diisi.',
            'judul_konten.string' => 'Judul konten harus berupa teks.',
            'judul_konten.max' => 'Judul konten maksimal 255 karakter.',
            'deskripsi_konten.required' => 'Deskripsi konten wajib diisi.',
            'deskripsi_konten.string' => 'Deskripsi konten harus berupa teks.',
            'thumbnail.required' => 'Thumbnail wajib diisi.',
            'thumbnail.string' => 'Thumbnail harus berupa teks.',
            'thumbnail.max' => 'Thumbnail maksimal 255 karakter.',
            'video_tutorial.string' => 'Video tutorial harus berupa teks.',
            'video_tutorial.max' => 'Video tutorial maksimal 255 karakter.',
            'status_konten.in' => 'Status konten tidak valid.',
        ];
    }
}