<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class SimpanResepModel extends Model
{
    use HasFactory;
    protected $table = "simpan_resep";
    protected $primaryKey = "id_simpan";
    protected $fillable = [
        "id_resep",
        "id_user"
    ];

    public function UserTable()
    {
        return $this->belongsTo(UserModel::class, 'id_user', 'id_user');
    }

    public function KontenResepTable()
    {
        return $this->belongsTo(KontenResepModel::class, 'id_resep', 'id_resep');
    }
}
