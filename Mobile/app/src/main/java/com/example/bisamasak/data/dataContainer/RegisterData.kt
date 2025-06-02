package com.example.bisamasak.data.dataContainer

data class RegisterRequest(
    val nama: String,
    val email: String,
    val password: String,
)

data class RegisterResponse(
    val message: String,
    val user: User
)

data class User(
    val id: Int,
    val nama: String,
    val email: String,
    val created_at: String,
    val updated_at: String
)