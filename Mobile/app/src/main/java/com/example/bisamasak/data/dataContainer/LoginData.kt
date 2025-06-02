package com.example.bisamasak.data.dataContainer

data class LoginRequest(
    val email: String,
    val password: String
)

data class LoginResponse(
    val message: String,
    val user: Users
)

data class Users(
    val id: Int,
    val email: String,
    val nama: String
)
