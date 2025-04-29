<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Builder;

class BahanMasakModel extends Model
{
    use HasFactory;
    protected $table = "bahan_masak";
    protected $primaryKey = "id_bahan";
    protected $fillable = [
        "nama_bahan",
        "deskripsi_bahan",
        "gambar_bahan",
        "terbuka_di_level"
    ];

    public function GiziTable()
    {
        return $this->hasMany(GiziModel::class, "id_bahan", "id_bahan");
    }

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, "id_resep", "id_resep");
    }

    public function scopeBahanMasak(Builder $query, $search): void
    {
        $query->where('nama_bahan', 'LIKE', '%' . $search . '%');
    }
}