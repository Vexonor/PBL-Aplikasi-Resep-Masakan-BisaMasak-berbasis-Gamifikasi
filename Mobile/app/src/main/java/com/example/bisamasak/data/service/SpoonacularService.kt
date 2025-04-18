package com.example.bisamasak.data.service

import com.example.bisamasak.data.dataContainer.IngredientDetailData
import com.example.bisamasak.data.response.IngredientResponse
import retrofit2.http.GET
import retrofit2.http.Query

    private const val key: String = "c99f7d80fbdf42f3a6900598bc7bc896"

interface SpoonacularService {
    @GET("food/ingredients/search")
    suspend fun searchIngredients(
        @Query("query") query: String,
        @Query("number") number: Int,
        @Query("apiKey") apiKey: String = key
    ): IngredientResponse

    @GET("food/ingredients/{id}/information")
    suspend fun getIngredientInformation(
        @retrofit2.http.Path("id") id: Int,
        @Query("amount") amount: Int = 1,
        @Query("apiKey") apiKey: String = key
    ): IngredientDetailData
}