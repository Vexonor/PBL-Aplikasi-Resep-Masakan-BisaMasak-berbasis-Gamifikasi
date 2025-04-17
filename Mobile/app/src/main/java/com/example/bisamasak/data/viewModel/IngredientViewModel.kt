package com.example.bisamasak.data.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.IngredientData
import com.example.bisamasak.data.dataContainer.IngredientDetailData
import com.example.bisamasak.data.instance.RetrofitInstance
import com.example.bisamasak.data.instance.RetrofitInstance.api
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class IngredientViewModel : ViewModel()  {

    private val _ingredients = MutableStateFlow<List<IngredientData>>(emptyList())
    val ingredients: StateFlow<List<IngredientData>> get() = _ingredients

    private val _ingredientDetail = MutableStateFlow<IngredientDetailData?>(null)
    val ingredientDetail: StateFlow<IngredientDetailData?> get() = _ingredientDetail

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> get() = _isLoading

    fun fetchIngredients(query: String, apiKey: String) {
        viewModelScope.launch {
            try {
                _isLoading.value = true
                val response = RetrofitInstance.api.searchIngredients(query, 5, apiKey)
                _ingredients.value = response.results
            } catch (e: Exception) {
                _ingredients.value = emptyList()
            } finally {
                _isLoading.value = false
            }
        }
    }

    fun fetchAllIngredients() {
        viewModelScope.launch {
            _isLoading.value = true
            val allIngredients = mutableListOf<IngredientData>()
            try {
                for (char in 'a' .. 'e') {
                    val response = api.searchIngredients(char.toString(), 2)
                    allIngredients.addAll(response.results)
                }
                _ingredients.value = allIngredients
            } catch (e: Exception) {
                Log.e("IngredientViewModel", "Failed to fetch: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun fetchIngredientDetail(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = api.getIngredientInformation(id)
                _ingredientDetail.value = response
            } catch (e: Exception) {
                Log.e("IngredientViewModel", "Failed to fetch: ${e.message}")
                _ingredientDetail.value = null
            } finally {
                _isLoading.value = false
            }
        }
    }
}