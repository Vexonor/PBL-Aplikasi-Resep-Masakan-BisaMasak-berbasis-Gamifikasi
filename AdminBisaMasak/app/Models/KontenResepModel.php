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

    public function BahanMasakTable()
    {
        return $this->hasMany(BahanMasakModel::class, "id_resep", "id_resep");
    }

    public function LaporanKontenTable()
    {
        return $this->hasMany(LaporanKontenModel::class, "id_resep", "id_resep");
    }

    public function scopeJudulKonten(Builder $query, $search): void
    {
        $query->where('judul_konten', 'LIKE', '%' . $search . '%');
    }
}
