<?php

namespace App\Models;

// use Illuminate\Contracts\Auth\MustVerifyEmail;
use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Foundation\Auth\User as Authenticatable;
use Illuminate\Notifications\Notifiable;
use Laravel\Sanctum\HasApiTokens;

class UserModel extends Authenticatable
{
    use HasApiTokens, Notifiable;
    protected $table = "users";
    protected $primaryKey = "id_user";
    protected $fillable = [
        'nama',
        'tanggal_lahir',
        'jenis_kelamin',
        'foto_profil',
        'email',
        'password',
        'peran'
    ];

    /**
     * The attributes that should be hidden for serialization.
     *
     * @var list<string>
     */
    protected $hidden = [
        'password',
        'remember_token',
    ];

    /**
     * Get the attributes that should be cast.
     *
     * @return array<string, string>
     */
    protected function casts(): array
    {
        return [
            'email_verified_at' => 'datetime',
            'password' => 'hashed',
        ];
    }

    public function AdminTable()
    {
        return $this->hasOne(AdminModel::class, 'id_user', 'id_user');
    }

    public function KontenResepTable()
    {
        return $this->hasOne(KontenResepModel::class, 'id_user', 'id_user');
    }
}