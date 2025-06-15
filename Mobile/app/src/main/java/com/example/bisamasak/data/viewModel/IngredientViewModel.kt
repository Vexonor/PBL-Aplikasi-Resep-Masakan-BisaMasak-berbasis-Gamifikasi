package com.example.bisamasak.data.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.IngredientResponse
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.launch

class IngredientViewModel : ViewModel()  {
    private val _relatedRecipes = mutableStateOf<List<RecipeContentResponse>>(emptyList())

    var ingredientList by mutableStateOf<List<IngredientResponse>>(emptyList())
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)
    var ingredientDetail by mutableStateOf<IngredientResponse?>(null)
    val relatedRecipes: List<RecipeContentResponse> get() = _relatedRecipes.value

    fun ingredient() {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = BisaMasakInstance.bisaMasakService.ingredient()
                ingredientList = response
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }

    fun ingredientDetail(id_bahan: Int) {
        viewModelScope.launch {
            isLoading = true
            try {
                val response = BisaMasakInstance.bisaMasakService.ingredientDetail(id_bahan)
                ingredientDetail = response
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
                Log.e("IngredientViewModel", "Failed to fetch detail: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun recipeByIngredient(ingredientName: String) {
        viewModelScope.launch {
            isLoading = true
            try {
                val  response = BisaMasakInstance.bisaMasakService.recipeContent()
                _relatedRecipes.value = response.filter { recipe ->
                    recipe.bahan_resep_table.any { bahan ->
                        bahan.bahan_masak_table?.nama_bahan?.equals(ingredientName, ignoreCase = true) == true
                    }
                }
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
                _relatedRecipes.value = emptyList()
            } finally {
                isLoading = false
            }
        }
    }
}