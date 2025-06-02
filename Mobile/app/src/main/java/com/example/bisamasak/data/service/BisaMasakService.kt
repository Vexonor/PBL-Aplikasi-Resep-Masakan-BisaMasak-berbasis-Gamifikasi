package com.example.bisamasak.data.service

import com.example.bisamasak.data.dataContainer.LoginRequest
import com.example.bisamasak.data.dataContainer.LoginResponse
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.dataContainer.RegisterRequest
import com.example.bisamasak.data.dataContainer.RegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface BisaMasakService {
//    Register
    @POST("register")
    suspend fun registerUser(@Body request: RegisterRequest): Response<RegisterResponse>

//    Login
    @POST("login")
    suspend fun loginUser(@Body request: LoginRequest): Response<LoginResponse>

//    Recipe Content
    @GET("konten-tutorial")
    suspend fun recipeContent(): List<RecipeContentResponse>
}