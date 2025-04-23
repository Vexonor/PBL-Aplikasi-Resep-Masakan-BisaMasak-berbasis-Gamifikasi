package com.example.bisamasak.data.utils

enum class RecipeCategory(val type: String){
    SARAPAN("breakfast"),
    MAKAN_SIANG("lunch"),
    MAKAN_MALAM("dinner"),
    CEMILAN("snack");

    companion object {
        fun fromString(type: String): RecipeCategory {
            return values().find { it.type.equals(type, ignoreCase = true) }
                ?: throw IllegalArgumentException("Unknown Category: $type")
        }
    }
}