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
        "durasi",
        "terbuka_di_level",
        "thumbnail",
        "video_tutorial",
        "status_konten",
        "kategori"
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

    public function LaporanKontenTable()
    {
        return $this->hasMany(LaporanKontenModel::class, "id_resep", "id_resep");
    }

    public function KomentarTable()
    {
        return $this->hasMany(KomentarModel::class, "id_resep", "id_user");
    }

    public function BahanMasakTable()
    {
        return $this->hasManyThrough(
            BahanMasakModel::class,
            BahanResepModel::class,
            'id_resep',
            'id_bahan',
            'id_resep',
            'id_bahan'
        );
    }

    public function scopeJudulKonten(Builder $query, array $keywords): Builder
    {
        return $query->where(function ($q) use ($keywords) {
            $q->where(function ($sub) use ($keywords) {
                foreach ($keywords as $keyword) {
                    $sub->orWhere('judul_konten', 'LIKE', '%' . $keyword . '%');
                }
            });

            $q->orWhereHas('BahanResepTable', function ($sub) use ($keywords) {
                $sub->whereHas('BahanMasakTable', function ($innerSub) use ($keywords) {
                    foreach ($keywords as $keyword) {
                        $innerSub->where('nama_bahan', 'LIKE', '%' . $keyword . '%');
                    }
                });
            });
        });
    }
}
