package com.example.bisamasak.data.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.Recipe
import com.example.bisamasak.data.dataContainer.RecipeResult
import com.example.bisamasak.data.instance.RetrofitInstance
import com.example.bisamasak.data.utils.RecipeCategory
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class RecipeViewModel : ViewModel() {

    private val _recipes = MutableStateFlow<List<RecipeResult>>(emptyList())
    val recipes: StateFlow<List<RecipeResult>> get() = _recipes

    private val _recipeDetails = MutableStateFlow<Recipe?>(null)
    val recipeDetails: StateFlow<Recipe?> get() = _recipeDetails

    private val _recipesByCategory = MutableStateFlow<Map<RecipeCategory, List<Recipe>>>(emptyMap())
    val recipesByCategory: StateFlow<Map<RecipeCategory, List<Recipe>>> get() = _recipesByCategory

    private val _searchResult = MutableStateFlow<List<Recipe>>(emptyList())
    val searchResult: StateFlow<List<Recipe>> get() = _searchResult

    private val _ingredientList = MutableStateFlow<List<String>>(emptyList())
    val ingredientList: StateFlow<List<String>> get() = _ingredientList

    private val _recipeByIngredients = MutableStateFlow<List<Recipe>>(emptyList())
    val recipeByIngredients: StateFlow<List<Recipe>> get() = _recipeByIngredients

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun fetchAllCategories(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val categories = RecipeCategory.entries
                val results = mutableMapOf<RecipeCategory, List<Recipe>>()
                for (category in categories) {
                    val response = RetrofitInstance.api.searchRecipes(category.type, number = 2)
                    results[category] = response.results
                }
                _recipesByCategory.value = results
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Failed to fetch recipes: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchRecipeDetails(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.getRecipeDetails(id)
                _recipeDetails.value = response
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Failed to fetch recipe details: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun searchRecipe(query: String){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = RetrofitInstance.api.searchRecipes(query = query, number = 2)
                _searchResult.value = response.results
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Failed to fetch recipes: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun addIngredient(ingredient: String){
        val trimmed = ingredient.trim().lowercase()
        if (!trimmed.isNotEmpty() && !_ingredientList.value.contains(trimmed))
            _ingredientList.value = _ingredientList.value + trimmed
    }

    fun clearIngredients(){
        _ingredientList.value = emptyList()
    }

    fun searchRecipeByIngredients(){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val ingredients = _ingredientList.value.joinToString(",")
                val response = RetrofitInstance.api.searchRecipeByIngredients(ingredients, 2)
                _recipeByIngredients.value = response
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Failed to fetch recipes: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun smartSearch(query: String){
        viewModelScope.launch {
            _isLoading.value = true
            try {
                if (query.contains(",")) {
                    clearIngredients()
                    query.split(",").forEach { addIngredient(it.trim()) }
                    searchRecipeByIngredients()
                } else {
                    searchRecipe(query)
                }
            } catch (e: Exception) {
                Log.e("RecipeViewModel", "Failed to fetch recipes: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
}