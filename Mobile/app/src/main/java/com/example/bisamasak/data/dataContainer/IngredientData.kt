package com.example.bisamasak.data.dataContainer

data class IngredientData (
    val id: Int,
    val name: String,
    val image: String
)

data class IngredientDetailData(
    val id: Int,
    val name: String,
    val image: String,
    val amount: Double,
    val unit: String,
    val nutrition: Nutrition
)

data class Nutrition(
    val nutrients: List<Nutrient>
)

data class Nutrient(
    val name: String,
    val amount: Double,
    val unit: String
)