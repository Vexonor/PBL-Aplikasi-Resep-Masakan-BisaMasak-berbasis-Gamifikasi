<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class LangkahLangkahModel extends Model
{
    use HasFactory;
    protected $table = "langkah_langkah";
    protected $primaryKey = "id_langkah";
    protected $fillable = [
        "id_resep",
        "nomor_langkah",
        "deskripsi_langkah",
        "gambar_langkah"
    ];

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, "id_resep", "id_resep");
    }
}
