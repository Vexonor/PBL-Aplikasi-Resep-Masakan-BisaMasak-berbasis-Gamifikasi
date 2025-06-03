package com.example.bisamasak.data.dataContainer

data class IngredientResponse(
    val id_bahan: Int,
    val nama_bahan: String,
    val deskripsi_bahan: String,
    val gambar_bahan: String,
    val gizi_table: List<GiziBahan>
)

data class GiziBahan(
    val id_gizi: Int,
    val id_bahan: Int,
    val nama_gizi: String,
    val jumlah: String,
    val satuan: String
)