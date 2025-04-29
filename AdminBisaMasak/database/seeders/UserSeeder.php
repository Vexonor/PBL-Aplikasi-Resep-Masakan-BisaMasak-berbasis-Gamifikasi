<?php

namespace Database\Seeders;

use App\Models\UserModel;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;
use Illuminate\Support\Facades\Hash;
use Illuminate\Support\Str;
use Faker\Factory as Faker;

class UserSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        $faker = Faker::create('id_ID');

        DB::table('users')->insertGetId([
            'id_user' => 1,
            'nama' => 'Master Admin',
            'tanggal_lahir' => $faker->date('Y-m-d', '2000-12-31'),
            'jenis_kelamin' => $faker->randomElement(['Laki-laki', 'Perempuan']),
            'foto_profil' => null,
            'email' => 'masteradmin@gmail.com',
            'email_verified_at' => now(),
            'password' => Hash::make('Password123'),
            'peran' => 'Admin',
            'remember_token' => Str::random(10),
            'created_at' => now(),
            'updated_at' => now(),
        ]);

        $user = UserModel::find(1);

        // Create a token for the user
        $token = $user->createToken('BisaMasak')->plainTextToken;

        // Optionally, you can log the token or save it somewhere
        echo "Generated Token: " . $token . "\n";
    }
}
