package com.example.bisamasak.data.dataContainer

import com.google.gson.annotations.SerializedName

data class RecipeResult(
    val results: List<Recipe>
)

data class Recipe(
    val id: Int,
    val title: String,
    val image: String,
    val readyInMinutes: Int,
    val summary: String,
    @SerializedName("analyzedInstructions")
    val parsedInstructions: List<AnalyzedInstruction>,
    val nutrition: RecipeNutrition,
    val extendedIngredients: List<RecipeIngredient>,
    @SerializedName("dishTypes")
    val dishTypes: List<String>,
)

data class RecipeIngredient(
    val name: String,
    val amount: Double,
    val unit: String,
)

data class RecipeNutrition(
    val nutrients: List<RecipeNutrient>,
    val caloricBreakdown: CaloricBreakdown
)

data class RecipeNutrient(
    val name: String,
    val amount: Double,
    val unit: String
)

data class CaloricBreakdown(
    val percentProtein: Double,
    val percentFat: Double,
    val percentCarbs: Double
)

data class AnalyzedInstruction(
    val steps: List<InstructionStep>
)

data class InstructionStep(
    val number: Int,
    val step: String,
    val ingredients: List<StepIngredient>,
    val equipment: List<StepEquipment>
)

data class StepIngredient(
    val name: String,
    val image: String
)

data class StepEquipment(
    val name: String,
    val image: String
)