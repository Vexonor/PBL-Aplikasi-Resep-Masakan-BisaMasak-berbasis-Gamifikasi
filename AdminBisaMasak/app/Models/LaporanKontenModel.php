<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Builder;

class LaporanKontenModel extends Model
{
    use HasFactory;
    protected $table = "laporan_konten";
    protected $primaryKey = "id_laporan";
    protected $fillable = [
        "id_resep",
        "deskripsi_laporan"
    ];

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, "id_resep", "id_resep");
    }

    public function scopeJudulKonten(Builder $query, ?string $search): Builder
    {
        if (empty($search)) {
            return $query;
        }

        return $query->whereHas('KontenResepTable', function ($q) use ($search) {
            $q->where('judul_konten', 'LIKE', '%' . $search . '%');
        });
    }
}
