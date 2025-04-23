package com.example.bisamasak.data.response

import com.example.bisamasak.data.dataContainer.RecipeResult


data class RecipeResponse(
    val results: List<RecipeResult>,
    val offset: Int,
    val number: Int,
    val totalResults: Int
)
