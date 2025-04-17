package com.example.bisamasak.data.service

import com.example.bisamasak.data.response.IngredientResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface SpoonacularService {
    @GET("food/ingredients/search")
    suspend fun searchIngredients(
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String
    ): IngredientResponse
}