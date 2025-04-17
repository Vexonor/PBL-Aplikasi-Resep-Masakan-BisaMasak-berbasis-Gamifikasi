package com.example.bisamasak.data.utils

fun formatIngredientName(name: String): String {
    return name
        .replace(" ", "_")
        .replace(Regex("[^a-zA-Z0-9 ]"), "")
        .trim()
        .split(" ")
        .joinToString(" ") { it.replaceFirstChar { char -> char.uppercase() } }
}