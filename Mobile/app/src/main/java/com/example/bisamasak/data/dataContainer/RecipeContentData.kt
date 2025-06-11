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
    val langkah_langkah_table: List<Langkah>,
    val created_at: String,
    val updated_at: String?,
    val id_user: Int?
)

data class BahanResep(
    val id_bahan: Int,
    val jumlah_bahan: String,
    val satuan_bahan: String,
    val bahan_masak_table: BahanMasak?,
    val id_bahan_resep: Int?,
    val id_resep: Int?,
    val created_at: String?,
    val updated_at: String?
)

data class BahanMasak(
    val id_bahan: Int,
    val nama_bahan: String,
    val deskripsi_bahan: String?,
    val gambar_bahan: String?,
    val created_at: String?,
    val updated_at: String?
)

data class Gizi(
    val nama_gizi: String,
    val jumlah: String,
    val satuan: String
)

data class Langkah(
    val nomor_langkah: Int,
    val deskripsi_langkah: String,
    val gambar_langkah: String?,
    val id_langkah: Int?,
    val id_resep: Int?,
    val created_at: String?,
    val updated_at: String?
)