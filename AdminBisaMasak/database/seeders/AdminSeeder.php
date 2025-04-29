<?php

namespace Database\Seeders;

use Illuminate\Database\Console\Seeds\WithoutModelEvents;
use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class AdminSeeder extends Seeder
{
    /**
     * Run the database seeds.
     */
    public function run(): void
    {
        DB::table('Admin')->insert([
            'id_user' => 1,
            'id_admin' => 1,
            'peran_admin' => 'Master Admin',
            'created_at' => now(),
            'updated_at' => now(),
        ]);
    }
}
