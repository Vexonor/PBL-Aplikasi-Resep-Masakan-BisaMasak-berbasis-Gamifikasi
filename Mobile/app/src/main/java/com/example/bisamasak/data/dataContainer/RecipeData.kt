package com.example.bisamasak.data.dataContainer

data class RecipeData(
    val foodImg: String,
    val foodName: String,
    val duration: Int,
)

data class RecipeVertical(
    val foodImg: String,
    val foodName: String,
    val description: String,
    val duration: Int,
)
