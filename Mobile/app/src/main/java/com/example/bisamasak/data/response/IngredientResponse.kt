package com.example.bisamasak.data.response

import com.example.bisamasak.data.dataContainer.IngredientData

data class IngredientResponse (
    val results: List<IngredientData>,
    val offset: Int,
    val number: Int,
    val totalResult: Int
)