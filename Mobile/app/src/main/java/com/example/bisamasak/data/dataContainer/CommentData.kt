package com.example.bisamasak.data.dataContainer

import com.google.gson.annotations.SerializedName

data class CommentResponse(
    val id_komentar: Int,
    val id_user: Int,
    val id_resep: Int,
    val isi_komentar: String,
    val created_at: String?,
    val updated_at: String?,
    val user_table: UserComment?,
    val konten_resep_table: Resep?
)

data class CommentStore(
    val id_user: Int,
    val id_resep: Int,
    val isi_komentar: String
)

data class UserComment(
    val id_user: Int,
    val nama: String,
    @SerializedName("foto_profil")
    val fotoProfil: String?
)

data class Resep(
    val id_resep: Int,
    val judul: String
)
