<?php

namespace Database\Seeders;

use Illuminate\Database\Seeder;
use Illuminate\Support\Facades\DB;

class KontenResepSeeder extends Seeder
{
    public function run(): void
    {

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Soto Ayam',
            'deskripsi_konten' => 'Mudah dibuat namun sangat menggugah selera.',
            'thumbnail' => 'thumbnail/soto-ayam.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 4,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 58,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 24,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 28,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'sdm',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 64,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => 'gambar_langkah/soto-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 165,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 21,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Ayam Woku',
            'deskripsi_konten' => 'Cocok disajikan untuk makan siang bersama keluarga.',
            'thumbnail' => 'thumbnail/resep-2.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 72,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 29,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 37,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 255,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 29,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Sate Ayam Bumbu Kacang',
            'deskripsi_konten' => 'Mudah dibuat namun sangat menggugah selera.',
            'thumbnail' => 'thumbnail/resep-3.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 77,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 84,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 39,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'kg',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 134,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 16,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Gulai Ikan',
            'deskripsi_konten' => 'Mudah dibuat namun sangat menggugah selera.',
            'thumbnail' => 'thumbnail/resep-4.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 4,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 96,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 87,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 97,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 34,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 59,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 153,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 14,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Opor Ayam',
            'deskripsi_konten' => 'Cocok disajikan untuk makan siang bersama keluarga.',
            'thumbnail' => 'thumbnail/resep-5.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'kg',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 74,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'ml',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 27,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 121,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 23,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Nasi Goreng Rumahan',
            'deskripsi_konten' => 'Masakan khas Indonesia dengan cita rasa yang kuat.',
            'thumbnail' => 'thumbnail/resep-6.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 79,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 48,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 34,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 86,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 188,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 11,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Mie Goreng Jawa',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/resep-7.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 57,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'sejumput',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 39,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 27,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 66,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 115,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 13,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Rendang Daging Sapi',
            'deskripsi_konten' => 'Cocok disajikan untuk makan siang bersama keluarga.',
            'thumbnail' => 'thumbnail/resep-9.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 4,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 50,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 45,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'cup',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 88,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 165,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 30,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Tumis Kangkung',
            'deskripsi_konten' => 'Masakan khas Indonesia dengan cita rasa yang kuat.',
            'thumbnail' => 'thumbnail/resep-10.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 85,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 79,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'sejumput',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 93,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 42,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'kg',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 67,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 144,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 26,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Lontong Sayur',
            'deskripsi_konten' => 'Masakan khas Indonesia dengan cita rasa yang kuat.',
            'thumbnail' => 'thumbnail/resep-13.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 5,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 73,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 30,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 84,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'ml',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 48,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 24,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'ml',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 191,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 14,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Sayur Lodeh',
            'deskripsi_konten' => 'Masakan khas Indonesia dengan cita rasa yang kuat.',
            'thumbnail' => 'thumbnail/resep-14.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 17,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 29,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'kg',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 69,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'sejumput',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 87,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 31,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'cup',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 110,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 12,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Sambal Matah',
            'deskripsi_konten' => 'Resep legendaris yang disukai banyak orang.',
            'thumbnail' => 'thumbnail/resep-15.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 57,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 15,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'butir',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 8,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 119,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 11,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Sambal Tomat Pedas',
            'deskripsi_konten' => 'Rasa gurih dan pedas berpadu sempurna.',
            'thumbnail' => 'thumbnail/resep-17.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 68,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 58,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'cup',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 28,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'ml',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 280,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 14,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Ikan Bakar Rica-Rica',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/resep-19.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 70,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 69,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'kg',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 15,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'kg',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 35,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'sdm',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 33,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 39,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 106,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 23,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Capcay Kuah',
            'deskripsi_konten' => 'Resep legendaris yang disukai banyak orang.',
            'thumbnail' => 'thumbnail/resep-21.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 46,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 41,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'butir',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 89,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'butir',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 42,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 53,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'cup',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 278,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 12,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Pecel Lele',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/resep-26.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 17,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 75,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 182,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 22,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Bakso Sapi',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/resep-30.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 56,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 43,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 94,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masukkan bahan utama dan aduk rata.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 119,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 14,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Telur Balado',
            'deskripsi_konten' => 'Masakan khas Indonesia dengan cita rasa yang kuat.',
            'thumbnail' => 'thumbnail/resep-37.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 63,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 66,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 77,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 30,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Haluskan bumbu dan tumis hingga harum.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 114,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 20,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('konten_resep')->insert([
            'id_user' => 1,
            'judul_konten' => 'Ayam Goreng Tradisional',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/resep-45.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 16,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 48,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 26,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 75,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 52,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'L',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masak hingga matang dan bumbu meresap.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tambahkan air atau santan bila perlu.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Siapkan semua bahan yang diperlukan.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Sajikan dengan nasi hangat.',
            'gambar_langkah' => null,
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Energi',
            'jumlah' => 218,
            'satuan' => 'kcal',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('gizi')->insert([
            'id_resep' => $resepId,
            'id_bahan' => null,
            'nama_gizi' => 'Protein',
            'jumlah' => 18,
            'satuan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);
    }
}
