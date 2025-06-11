<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;

class PenggunaModel extends Model
{
    use HasFactory;
    protected $table = "pengguna";
    protected $primaryKey = "id_pengguna";
    protected $fillable = [
        "id_user",
        "poin_level",
        "level_pengguna",
    ];

    public function UserTable()
    {
        return $this->belongsTo(UserModel::class, 'id_user', 'id_user');
    }
}
