<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Builder;

class KontenResepModel extends Model
{
    use HasFactory;
    protected $table = "konten_resep";
    protected $primaryKey = "id_resep";
    protected $fillable = [
        "id_user",
        "judul_konten",
        "deskripsi_konten",
        "terbuka_di_level",
        "thumbnail",
        "video_tutorial",
        "status_konten"
    ];

    public function UserTable()
    {
        return $this->belongsTo(UserModel::class, "id_user", "id_user");
    }

    public function BahanResepTable()
    {
        return $this->hasMany(BahanResepModel::class, "id_resep", "id_resep");
    }

    public function GiziTable()
    {
        return $this->hasMany(GiziModel::class, "id_resep", "id_resep");
    }

    public function LangkahLangkahTable()
    {
        return $this->hasMany(LangkahLangkahModel::class, "id_resep", "id_resep");
    }

    public function BahanMasakTable()
    {
        return $this->hasMany(BahanMasakModel::class, "id_resep", "id_resep");
    }

    public function scopeSearchByBahanOrJudul(Builder $query, $keywords)
    {
        $query->where(function ($q) use ($keywords) {
            // Search Recipe Name
            $q->where(function ($subQuery) use ($keywords) {
                foreach ((array)$keywords as $keyword) {
                    $subQuery->orWhere('judul_konten', 'LIKE', '%' . $keyword . '%');
                }
            });

            // Search Ingredient
            $q->orWhereHas('BahanResepTable', function ($bahanQuery) use ($keywords) {
                $bahanQuery->where(function ($subQuery) use ($keywords) {
                    foreach ((array)$keywords as $keyword) {
                        $subQuery->orWhere('nama_bahan', 'LIKE', '%' . $keyword . '%');
                    }
                });
            });
        });
    }
}
