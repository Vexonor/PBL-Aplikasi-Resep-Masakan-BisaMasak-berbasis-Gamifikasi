package com.example.bisamasak.data.service

import com.example.bisamasak.BuildConfig
import com.example.bisamasak.data.dataContainer.Recipe
import com.example.bisamasak.data.dataContainer.RecipeResult
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

private const val key: String = BuildConfig.API_KEY

interface SpoonacularService {
        @GET("recipes/complexSearch")
        suspend fun searchRecipes(
                @Query("query") query: String? = null,
                @Query("type") type: String? = null,
                @Query("number") number: Int,
                @Query("addRecipeInformation") addRecipeInformation: Boolean = true,
                @Query("apiKey") apiKey: String = key
        ): RecipeResult

        @GET("recipes/{id}/information")
        suspend fun getRecipeDetails(
                @Path("id") id: Int,
                @Query("includeNutrition") includeNutrition: Boolean = true,
                @Query("apiKey") spiKey: String = key
        ): Recipe

        @GET("recipes/findByIngredients")
        suspend fun searchRecipeByIngredients(
                @Query("ingredients") ingredients: String,
                @Query("number") number: Int,
                @Query("apiKey") apiKey: String = key
        ): List<Recipe>
}
