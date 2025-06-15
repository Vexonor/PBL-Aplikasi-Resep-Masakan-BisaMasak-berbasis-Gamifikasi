<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class KomentarModel extends Model
{
    use HasFactory;
    protected $table = "komentar";
    protected $primaryKey = "id_komentar";
    protected $fillable = [
        "id_user",
        "id_resep",
        "isi_komentar"
    ];

    public function UserTable()
    {
        return $this->belongsTo(UserModel::class, "id_user", "id_user");
    }

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, "id_resep", "id_resep");
    }
}
