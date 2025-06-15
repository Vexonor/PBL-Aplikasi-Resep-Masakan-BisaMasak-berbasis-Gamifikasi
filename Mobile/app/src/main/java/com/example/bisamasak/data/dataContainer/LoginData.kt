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

data class Users(
    @SerializedName("id_user")
    val id: Long,
    val email: String,
    val nama: String
)
