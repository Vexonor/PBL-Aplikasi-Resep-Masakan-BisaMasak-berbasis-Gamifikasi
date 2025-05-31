<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class BahanResepModel extends Model
{
    use HasFactory;
    protected $table = "bahan_untuk_resep";
    protected $primaryKey = "id_bahan_resep";
    protected $fillable = [
        "id_resep",
        "id_bahan",
        "jumlah_bahan",
        "satuan_bahan"
    ];

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, "id_resep", "id_resep");
    }

    public function BahanMasakTable()
    {
        return $this->belongsTo(BahanMasakModel::class, "id_bahan", "id_bahan");
    }
}