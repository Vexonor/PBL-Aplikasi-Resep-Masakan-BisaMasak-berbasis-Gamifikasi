package com.example.bisamasak.data.dataContainer

import com.google.gson.annotations.SerializedName

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val message: String,
    val user: Users
)

data class Pengguna(
    @SerializedName("id_pengguna")
    val idPengguna: Long,
    @SerializedName("id_user")
    val idUser: Long,
    @SerializedName("poin_level")
    val poinLevel: Long,
    @SerializedName("level_pengguna")
    val levelPengguna: Int,
    @SerializedName("created_at")
    val createdAt: String,
    @SerializedName("updated_at")
    val updatedAt: String,
    @SerializedName("user_table")
    val user: Users
)

data class Users(
    @SerializedName("id_user")
    val id: Long,
    val email: String,
    val nama: String,
    @SerializedName("tanggal_lahir")
    val tanggalLahir: String?,
    @SerializedName("jenis_kelamin")
    val jenisKelamin: String?,
    @SerializedName("foto_profil")
    val fotoProfil: String?
)
