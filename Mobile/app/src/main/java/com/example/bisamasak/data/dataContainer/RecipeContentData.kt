package com.example.bisamasak.data.dataContainer

data class RecipeContentResponse(
    val id_resep: Int,
    val judul_konten: String,
    val deskripsi_konten: String,
    val durasi: Int,
    val thumbnail: String?,
    val video_tutorial: String?,
    val status_konten: String,
    val kategori: String,
    val terbuka_di_level: Int,
    val bahan_resep_table: List<BahanResep>,
    val gizi_table: List<Gizi>,
    val langkah_langkah_table: List<Langkah>
)

data class BahanResep(
    val id_bahan: Int,
    val jumlah_bahan: String,
    val satuan_bahan: String
)

data class Gizi(
    val nama_gizi: String,
    val jumlah: String,
    val satuan: String
)

data class Langkah(
    val nomor_langkah: Int,
    val deskripsi_langkah: String,
    val gambar_langkah: String?
)