<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Model;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Builder;

class AdminModel extends Model
{
    use HasFactory;
    protected $table = "admin";
    protected $primaryKey = "id_admin";
    protected $fillable = [
        "id_user",
        "peran_admin",
    ];

    public function UserTable()
    {
        return $this->belongsTo(UserModel::class, 'id_user', 'id_user');
    }

    public function scopeAdmin(Builder $query, $search): void
    {
        $query->whereHas('UserTable', function ($adminQuery) use ($search) {
            $adminQuery->where('nama', 'LIKE', '%' . $search . '%')
                ->orWhere('email', 'LIKE', '%' . $search . '%');
        });
    }
}
