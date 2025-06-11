package com.example.bisamasak.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.BahanResep
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class RecipeContentViewModel : ViewModel() {
    private val _recipeList = MutableStateFlow<List<RecipeContentResponse>>(emptyList())
    private val _searchResult = MutableStateFlow<List<RecipeContentResponse>>(emptyList())
    var recipeList = _recipeList.asStateFlow()
    val groupedRecipes: Map<String, List<RecipeContentResponse>>
        get() = _recipeList.value.groupBy { it.kategori?.trim()?.lowercase() ?: "Lainnya" }
    var selectedRecipe by mutableStateOf<RecipeContentResponse?>(null)
    var searchResult = _searchResult.asStateFlow()
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun recipe() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = BisaMasakInstance.bisaMasakService.recipeContent()
                _recipeList.value = response
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }
    fun recipeDetails(recipeId: Int) {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response  = BisaMasakInstance.bisaMasakService.recipeContent()
                _recipeList.value = response
                selectedRecipe = response.find { it.id_resep == recipeId }
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }
    fun similarRecipe(recipeId: Int, ingredient: List<BahanResep>): List<RecipeContentResponse> {
        val allRecipes = _recipeList.value.filter { it.id_resep != recipeId }

        val currentIngredient = ingredient.map {
            it.bahan_masak_table?.nama_bahan?.lowercase() ?: ""
        }.filter { it.isNotBlank() }.toSet()

        return allRecipes.map { recipe ->
            val ingredientName = recipe.bahan_resep_table?.map {
                it.bahan_masak_table?.nama_bahan?.lowercase() ?: ""
            }?.filter { it.isNotBlank() }?.toSet() ?: emptySet()

            val commonIngredient = currentIngredient.intersect(ingredientName)
            recipe to commonIngredient.size
        }
            .filter { (_, count) -> count > 0 }
            .sortedByDescending { (_, count) -> count }
            .take(5)
            .map { (recipe, _) -> recipe }
    }
    fun searchRecipes(query: String){
        viewModelScope.launch {
            isLoading = true
            try {
                val keywords = query.lowercase()
                    .split(",", " ", ";")
                    .map { it.trim() }
                    .filter { it.isNotBlank() }

                val response = BisaMasakInstance.bisaMasakService.searchRecipes(keywords)
                _searchResult.value = response
            } catch (e: Exception) {
                _searchResult.value = emptyList()
                errorMessage = e.message
            } finally {
                isLoading = false
            }
        }
    }
}