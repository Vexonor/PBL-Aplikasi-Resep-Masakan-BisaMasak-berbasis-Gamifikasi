<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class GiziModel extends Model
{
    use HasFactory;
    protected $table = "gizi";
    protected $primaryKey = "id_gizi";
    protected $fillable = [
        "id_bahan",
        "id_resep",
        "nama_gizi",
        "jumlah",
        "satuan"
    ];

    public function BahanMasakTable()
    {
        return $this->belongsTo(BahanMasakModel::class, "id_bahan", "id_bahan");
    }

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, "id_resep", "id_resep");
    }
}
