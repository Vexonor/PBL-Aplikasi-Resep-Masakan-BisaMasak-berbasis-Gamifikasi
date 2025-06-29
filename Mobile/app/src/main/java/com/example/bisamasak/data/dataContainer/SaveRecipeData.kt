package com.example.bisamasak.data.dataContainer

data class SaveRecipeResponse(
    val message: String,
    val data: SaveRecipeData?
)

data class SaveRecipeData(
    val id_simpan: Int,
    val id_user: Int,
    val id_resep: Int,
    val created_at: String,
    val updated_at: String
)

data class SaveRecipeRequest(
    val id_user: Int,
    val id_resep: Int
)

data class CheckSaveRecipe(
    val sudah_disimpan: Boolean
)

data class ListSavedResponse(
    val message: String,
    val data: List<SavedRecipe>
)

data class SavedRecipe(
    val recipe: RecipeContentResponse,
    val saved_at: String
)