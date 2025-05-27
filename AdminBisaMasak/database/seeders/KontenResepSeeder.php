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
            'id_bahan' => 19,
            'jumlah_bahan' => '250',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 6,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 7,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Cuci bersih ayam, rebus sampai matang, goreng, lalu suir-suir, sisihkan.',
            'gambar_langkah' => 'gambar_langkah/soto-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Sisihkan air bekas rebusan ayam, untuk kuah.',
            'gambar_langkah' => 'gambar_langkah/soto-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Haluskan bumbu halus, bersama bumbu-bumbu lain.',
            'gambar_langkah' => 'gambar_langkah/soto-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tumis campuran bumbu halus sampai wangi, lalu tuang ke dalam air yg tadi dipake buat merebus ayam, didihkan lagi kuah soto, bumbui garam dan gula , lalu tes rasanya.',
            'gambar_langkah' => 'gambar_langkah/soto-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Tata dalam mangkuk saji: ayam suir, irisan kol, toge, soun rebus, dan kentang goreng',
            'gambar_langkah' => 'gambar_langkah/soto-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Siram dengan kuah soto, tambahkan diatasnya potongan tomat, daun bawang, seledri dan jeruk nipis, sajikan.',
            'gambar_langkah' => 'gambar_langkah/soto-6.webp',
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
            'thumbnail' => 'thumbnail/ayam-woku.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 19,
            'jumlah_bahan' => '500',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '7',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 8,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Potong-potong ayam dan cuci bersih.',
            'gambar_langkah' => 'gambar_langkah/woku-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Blender bumbu hingga halus.',
            'gambar_langkah' => 'gambar_langkah/woku-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Tumis bumbu halus beserta daun jeruk, daun pandan dan serai hingga bumbu matang.',
            'gambar_langkah' => 'gambar_langkah/woku-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Masukkan ayam dan aduk hingga kaku.',
            'gambar_langkah' => 'gambar_langkah/woku-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukkan air, garam, gula pasir, dan kaldu jamur, masak hingga matang.',
            'gambar_langkah' => 'gambar_langkah/woku-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Setelah matang dan kuah menyusut, tambahan daun kemangi dan aduk rata.',
            'gambar_langkah' => 'gambar_langkah/woku-6.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 7,
            'deskripsi_langkah' => 'Cicipi rasanya dan siap disajikan.',
            'gambar_langkah' => 'gambar_langkah/woku-7.webp',
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
            'thumbnail' => 'thumbnail/sate-kacang.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 19,
            'jumlah_bahan' => '250',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'sdt',
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
            'id_bahan' => 1,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Potong-potong ayam fillet dadu kecil, kemudian kucari dengan 1 buah jeruk limau peras, biarkan 1 jam di kulkas. Kemudian bilas dengan air dan tiriskan.',
            'gambar_langkah' => 'gambar_langkah/sate-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masukan bawang putih halus, merica, dan garam, aduk rata, simpan lagi 1 jam di kulkas.',
            'gambar_langkah' => 'gambar_langkah/sate-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Sambil menunggu bumbu meresap, goreng kacang tanah hingga matang. Blender dengan 150 ml air matang, sisihkan.',
            'gambar_langkah' => 'gambar_langkah/sate-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Haluskan bawang merah, bawang putih, dan cabe merah keriting. Kemudian tumis bersama daun jeruk hingga harum.',
            'gambar_langkah' => 'gambar_langkah/sate-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Setelah bumbu meresap, tusuk-tusuk pada tusukan sate hingga padat (tidak berjarak).',
            'gambar_langkah' => 'gambar_langkah/sate-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Siapkan bumbu oles. kemudian oles-oles sate sebelum di bakar.',
            'gambar_langkah' => 'gambar_langkah/sate-6.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 7,
            'deskripsi_langkah' => 'Panaskan pembakaran, dan panggang, sesekali oleskan dengan bumbu. Lakukan hingga sate matang.',
            'gambar_langkah' => 'gambar_langkah/sate-7.webp',
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
            'thumbnail' => 'thumbnail/gulai-ikan.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 4,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '7',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 4,
            'jumlah_bahan' => '7',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 9,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Bersihkan ikan patin yg sudah dipotong-potong, lumuri dengan jeruk nipis, diamkan selama ± 15 menit, cuci lagi sampai bersih.',
            'gambar_langkah' => 'gambar_langkah/gulai-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Haluskan semua bumbu. Masak dalam wajan hingga mendidih.',
            'gambar_langkah' => 'gambar_langkah/gulai-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan ikan. Tes rasa.',
            'gambar_langkah' => 'gambar_langkah/gulai-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Masak hingga kuah meresap dan volumenya menyusut. Angkat.',
            'gambar_langkah' => 'gambar_langkah/gulai-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Pindahkan ke piring. Siap disajikan.',
            'gambar_langkah' => 'gambar_langkah/gulai-5.webp',
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
            'thumbnail' => 'thumbnail/opor-ayam.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 19,
            'jumlah_bahan' => '350',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 16,
            'jumlah_bahan' => '50',
            'satuan_bahan' => 'ml',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 9,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 6,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 7,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Siapkan bahan.',
            'gambar_langkah' => 'gambar_langkah/opor-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Cuci ayam. Kemudian rebus sebentar. Lalu cuci kembali dan tiriskan.',
            'gambar_langkah' => 'gambar_langkah/opor-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Panaskan minyak lalu tumis bumbu halus jadi, dan Semua bahan Bumbu. Masak sampai tidak berbau mentah.',
            'gambar_langkah' => 'gambar_langkah/opor-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Lalu masukan ayam dan air. Aduk, biarkan sampai air mendidih.',
            'gambar_langkah' => 'gambar_langkah/opor-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Kemudian tambahkan santan cair, kaldu jamur, gula pasir, lada bubuk dan garam secukupnya. Biarkan sampai air kuah sedikit menyusut.',
            'gambar_langkah' => 'gambar_langkah/opor-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Cicipi rasa, lalu tambahkan lagi santan kental. Aduk rata. Masak sampai matang, angkat dan siap disajikan dengan taburan bawang goreng.',
            'gambar_langkah' => 'gambar_langkah/opor-6.webp',
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
            'judul_konten' => 'Nasi Goreng Ikan Teri',
            'deskripsi_konten' => 'Masakan khas Indonesia dengan cita rasa yang kuat.',
            'thumbnail' => 'thumbnail/nasi-goreng.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 13,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'sdm',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Goreng ikan teri tawar.',
            'gambar_langkah' => 'gambar_langkah/nasgor-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tumis bumbu halus hingga aromanya harum.',
            'gambar_langkah' => 'gambar_langkah/nasgor-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan nasi lalu aduk hingga semua tercampur.',
            'gambar_langkah' => 'gambar_langkah/nasgor-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tambahkan kecap asin, kaldu jamur, lada bubuk, garam.',
            'gambar_langkah' => 'gambar_langkah/nasgor-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukkan ikan teri goreng dan kecap manis lalu aduk serta koreksi rasa sesuai. Angkat dan sajikan.',
            'gambar_langkah' => 'gambar_langkah/nasgor-5.webp',
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
            'judul_konten' => 'Mie Aceh',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/mie-aceh.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 19,
            'jumlah_bahan' => '100',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 5,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '6',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '4',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Rebus mie setengah matang. Angkat dan tiriskan.',
            'gambar_langkah' => 'gambar_langkah/aceh-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tumis bumbu iris sampai harum dan layu.',
            'gambar_langkah' => 'gambar_langkah/aceh-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan ayam. Masak sampai berubah warna. Kemudian masukkan bakso dan kol. Masak sampai layu.',
            'gambar_langkah' => 'gambar_langkah/aceh-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tambahkan air dan seasoning. Aduk rata.',
            'gambar_langkah' => 'gambar_langkah/aceh-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukkan taoge, daun bawang, tomat dan cabai merah. Aduk rata. Masak sebentar. Icip rasa. Angkat dan sajikan.',
            'gambar_langkah' => 'gambar_langkah/aceh-5.webp',
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
            'judul_konten' => 'Rendang Sapi',
            'deskripsi_konten' => 'Cocok disajikan untuk makan siang bersama keluarga.',
            'thumbnail' => 'thumbnail/rendang-sapi.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 4,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 8,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 7,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 9,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Potong-potong daging, cuci bersih, tiriskan, sisihkan.',
            'gambar_langkah' => 'gambar_langkah/rendang-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Sebelum memasak bumbu rendang sapi, siapkan bumbu halus dan rempah daun.',
            'gambar_langkah' => 'gambar_langkah/rendang-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masak santan dalam panci presto sambil diaduk terus sampai mendidih.',
            'gambar_langkah' => 'gambar_langkah/rendang-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Masukan bumbu halus dan rempah daun, aduk rata. Lalu masukan potongan daging, aduk rata.',
            'gambar_langkah' => 'gambar_langkah/rendang-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Tutup rapat panci presto. Masak kurang lebih 30 menit.',
            'gambar_langkah' => 'gambar_langkah/rendang-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Masak terus sampai kuah susut, mengental dan daging empuk, kurang lebih 30 menit.',
            'gambar_langkah' => 'gambar_langkah/rendang-6.webp',
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
            'thumbnail' => 'thumbnail/tumis-kangkung.jpg',
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
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 4,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Tumis bawang hingga harum.',
            'gambar_langkah' => 'gambar_langkah/tumis-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tambahkan cabai.',
            'gambar_langkah' => 'gambar_langkah/tumis-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Selanjutnya tambahkan garam, penyedap rasa, dan gula pasir.',
            'gambar_langkah' => 'gambar_langkah/tumis-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Masukkan kangkung, kemudian tambahkan sedikit air.',
            'gambar_langkah' => 'gambar_langkah/tumis-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masak hingga kangkung matang.',
            'gambar_langkah' => 'gambar_langkah/tumis-5.webp',
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
            'thumbnail' => 'thumbnail/lontong-sayur.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 5,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
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
            'id_bahan' => 12,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 8,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'TCuci bersih sayuran lalu iris sayuran sesuai selera.',
            'gambar_langkah' => 'gambar_langkah/lontong-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tumis bumbu yang sudah dihaluskan sampai bumbu matang.',
            'gambar_langkah' => 'gambar_langkah/lontong-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'masukan daun salam dan daun jeruk aduk rata.',
            'gambar_langkah' => 'gambar_langkah/lontong-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Jika sudah matang bumbu nya masukan air lalu beri bumbu garam, gula dan kaldu bubuk.',
            'gambar_langkah' => 'gambar_langkah/lontong-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukan sayuran, masak sampai ½ matang.',
            'gambar_langkah' => 'gambar_langkah/lontong-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Masukan santan, nasak sampai mendidih dan sayuran matang, jangan lupa koreksi rasa.',
            'gambar_langkah' => 'gambar_langkah/lontong-6.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 7,
            'deskripsi_langkah' => 'Sajikan dengan lontong dan beri telur rebus sebagai pelengkap.',
            'gambar_langkah' => 'gambar_langkah/lontong-7.webp',
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
            'thumbnail' => 'thumbnail/sayur-lodeh.jpg',
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
            'id_bahan' => 2,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 12,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 21,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Siapkan bahan-bahan yang dibutuhkan.',
            'gambar_langkah' => 'gambar_langkah/lodeh-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Potong kecil-kecil sayuran.',
            'gambar_langkah' => 'gambar_langkah/lodeh-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Siapkan bumbu.',
            'gambar_langkah' => 'gambar_langkah/lodeh-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Ulek bumbu hingga halus. Siapkan santan.',
            'gambar_langkah' => 'gambar_langkah/lodeh-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masak sayur hingga matang.',
            'gambar_langkah' => 'gambar_langkah/lodeh-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Sayur lodeh siap disajikan.',
            'gambar_langkah' => 'gambar_langkah/lodeh-6.webp',
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
            'thumbnail' => 'thumbnail/sambal-matah.jpg',
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
            'jumlah_bahan' => '6',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 4,
            'jumlah_bahan' => '15',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 9,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'batang',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Campur cabai, bawang, serai, dan daun jeruk.',
            'gambar_langkah' => 'gambar_langkah/matah-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masukkan garam dan gula pasir, lalu aduk rata.',
            'gambar_langkah' => 'gambar_langkah/matah-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Panaskan minyak goreng.',
            'gambar_langkah' => 'gambar_langkah/matah-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Lalu tuang minyak panas ke bahan sambal.',
            'gambar_langkah' => 'gambar_langkah/matah-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Beri air lemon, lalu aduk rata dan cicipi rasanya.',
            'gambar_langkah' => 'gambar_langkah/matah-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Kemudian sajikan.',
            'gambar_langkah' => 'gambar_langkah/matah-6.webp',
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
            'judul_konten' => 'Sambal Bajak',
            'deskripsi_konten' => 'Rasa gurih dan pedas berpadu sempurna.',
            'thumbnail' => 'thumbnail/sambal-bajak.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 5,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 4,
            'jumlah_bahan' => '10',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 15,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Kukus semua bahan menggunakan panci dandang selama ±5 menit.',
            'gambar_langkah' => 'gambar_langkah/bajak-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Dalam cobek, masukkan semua bahan. Tambahkan terasi, garam, kaldu bubuk, dan gula.',
            'gambar_langkah' => 'gambar_langkah/bajak-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Haluskan',
            'gambar_langkah' => 'gambar_langkah/bajak-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Panaskan 4 sdm minyak goreng. Goreng sambal hingga matang sembari tes rasa.',
            'gambar_langkah' => 'gambar_langkah/bajak-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Sajikan.',
            'gambar_langkah' => 'gambar_langkah/bajak-5.webp',
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
            'judul_konten' => 'Pepes Tahu Pedas',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/pepes-tahu.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 18,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Haluskan tahu.',
            'gambar_langkah' => 'gambar_langkah/pepes-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Masukkan telur, daun kemangi dan daun bawang.',
            'gambar_langkah' => 'gambar_langkah/pepes-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Bumbui dengan garam, kaldu bubuk dan lada bubuk.',
            'gambar_langkah' => 'gambar_langkah/pepes-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Simpan di wadah tahan panas, kukus selama 30 menit.',
            'gambar_langkah' => 'gambar_langkah/pepes-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Sajikan selagi hangat.',
            'gambar_langkah' => 'gambar_langkah/pepes-5.webp',
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
            'thumbnail' => 'thumbnail/capcay-kuah.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 19,
            'jumlah_bahan' => '100',
            'satuan_bahan' => 'g',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '7',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 15,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);


        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Persiapkan aneka bawang.',
            'gambar_langkah' => "gambar_langkah/capcay-1.webp",
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Persiapkan aneka sayurannya.',
            'gambar_langkah' => "gambar_langkah/capcay-2.webp",
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Agar lebih cepat empuk sayurannya aku rebus terlebih dahulu.',
            'gambar_langkah' => "gambar_langkah/capcay-3.webp",
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Panaskan minyak, aku pakai minyak ayam agar lebih wangi, caranya dengan menumis kulit ayam dengan sedikit minyak.',
            'gambar_langkah' => "gambar_langkah/capcay-4.webp",
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Masukkan aneka sayuran, tambahkan air/ kaldu secukupnya lalu bumbui dengan saus tiram, garam, gula, lada putih dan penyedap rasa jamur/ ayam sesuai selera.',
            'gambar_langkah' => "gambar_langkah/capcay-5.webp",
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
            'thumbnail' => 'thumbnail/pecel-lele.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 16,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 20,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'secukupnya',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 5,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Bersihkan ikan lalu haluskan bumbu, balur ikan dengan bumbu dan biarkan selama 15 menit sampai bumbu meresap.',
            'gambar_langkah' => 'gambar_langkah/pecel-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Panaskan minyak lalu goreng ikan sampai matang dan sedikit kering. Lakukan sampai ikan habis digoreng.',
            'gambar_langkah' => 'gambar_langkah/pecel-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Siapkan bahan sambal. Goreng tomat, bawang merah, bawang putih dan cabe sampai layu.',
            'gambar_langkah' => 'gambar_langkah/pecel-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Pindahkan kedalam cobek, beri bumbu garam, gula, penyedap dan terasi matang. Ulek sampai halus.',
            'gambar_langkah' => 'gambar_langkah/pecel-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Sajikan pecel lele bersama sambal dan pelengkap lainnya.',
            'gambar_langkah' => 'gambar_langkah/pecel-5.webp',
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
            'thumbnail' => 'thumbnail/bakso-sapi.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 18,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 14,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masukan irisan daging ke dalam blender, lalu blender sampai setengah halus. Kemudian susul dengan es batu dan putih telur, dan blender lagi sampai halus.',
            'gambar_langkah' => 'gambar_langkah/bakso-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Lalu masukan juga tepung tapioka, baking powder, garam, lada, dan bawang putih goreng. Blender lagi sampai tercampur rata.',
            'gambar_langkah' => 'gambar_langkah/bakso-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Pindahkan ke dalam baskom, kemudian uleni lagi selama 5 menit.',
            'gambar_langkah' => 'gambar_langkah/bakso-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Siapkan air yang sudah dipanaskan, kecilkan api, lalu bentuk bakso menjadi bulatan bakso.',
            'gambar_langkah' => 'gambar_langkah/bakso-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Lakukan sampai selesai, dan masak sampai bakso mengapung.',
            'gambar_langkah' => 'gambar_langkah/bakso-5.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 6,
            'deskripsi_langkah' => 'Pindahkan ke dalam air berisi es batu.',
            'gambar_langkah' => 'gambar_langkah/bakso-6.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 7,
            'deskripsi_langkah' => 'Tiriskan, kemudian bakso siap diolah.',
            'gambar_langkah' => 'gambar_langkah/bakso-7.webp',
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
            'thumbnail' => 'thumbnail/telur-balado.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 2,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 18,
            'jumlah_bahan' => '10',
            'satuan_bahan' => 'butir',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 1,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 2,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'siung',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 3,
            'jumlah_bahan' => '15',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 5,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 21,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 11,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Siapkan semua bahan balado yaitu cabai, bawang merah, bawang putih dan tomat',
            'gambar_langkah' => 'gambar_langkah/balado-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Rebus telur jika sudah masak, tiriskan.',
            'gambar_langkah' => 'gambar_langkah/balado-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Lalu goreng telur yang sudah direbus tadi dengan api sedang.',
            'gambar_langkah' => 'gambar_langkah/balado-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tumis balado hingga airnya menyusut.',
            'gambar_langkah' => 'gambar_langkah/balado-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Tambahkan telur, garam, kaldu jamur(optional), lada bubuk, ketumbar bubuk, daun jeruk bubuk, kunyit bubuk, gula lalu aduk hingga merata dan telur balado siap untuk dihidangkan.',
            'gambar_langkah' => 'gambar_langkah/balado-5.webp',
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
            'judul_konten' => 'Ayam Goreng Lengkuas',
            'deskripsi_konten' => 'Kombinasi bumbu rempah yang kaya rasa.',
            'thumbnail' => 'thumbnail/ayam-goreng.jpg',
            'video_tutorial' => null,
            'status_konten' => ['Draf', 'Terunggah', 'Terblokir'][rand(0, 2)],
            'terbuka_di_level' => 3,
            'created_at' => now(),
            'updated_at' => now()
        ]);
        $resepId = DB::getPdo()->lastInsertId();

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 19,
            'jumlah_bahan' => '5',
            'satuan_bahan' => 'potong',
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
            'id_bahan' => 21,
            'jumlah_bahan' => '1/2',
            'satuan_bahan' => 'sdt',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 12,
            'jumlah_bahan' => '3',
            'satuan_bahan' => 'buah',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 10,
            'jumlah_bahan' => '2',
            'satuan_bahan' => 'lembar',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('bahan_untuk_resep')->insert([
            'id_resep' => $resepId,
            'id_bahan' => 6,
            'jumlah_bahan' => '1',
            'satuan_bahan' => 'potong',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 1,
            'deskripsi_langkah' => 'Masukkan bawang putih, bawang merah, kemiri, jahe, blender hingga halus.',
            'gambar_langkah' => 'gambar_langkah/ayam-1.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 2,
            'deskripsi_langkah' => 'Tumis bumbu yang telah dihaluskan, tambahkan parutan lengkuas, daun salam, sereh, ketumbar bubuk, dan kunyit bubuk hingga harum.',
            'gambar_langkah' => 'gambar_langkah/ayam-2.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 3,
            'deskripsi_langkah' => 'Masukkan ayam dan beri air masak hingga bumbu meresap.',
            'gambar_langkah' => 'gambar_langkah/ayam-3.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 4,
            'deskripsi_langkah' => 'Tambahkan garam, gula, lada, dan kaldu bubuk, aduk hingga tercampur rata, sisihkan.',
            'gambar_langkah' => 'gambar_langkah/ayam-4.webp',
            'created_at' => now(),
            'updated_at' => now()
        ]);

        DB::table('langkah_langkah')->insert([
            'id_resep' => $resepId,
            'nomor_langkah' => 5,
            'deskripsi_langkah' => 'Panaskan minyak goreng, goreng ayam hingga matang.',
            'gambar_langkah' => 'gambar_langkah/ayam-5.webp',
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
