package com.example.bisamasak.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.launch

class RecipeContentViewModel : ViewModel() {
    var recipeList by mutableStateOf<List<RecipeContentResponse>>(emptyList())
    val groupedRecipes: Map<String, List<RecipeContentResponse>>
        get() = recipeList.groupBy { it.kategori?.trim()?.lowercase() ?: "Lainnya" }
    var isLoading by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun recipe() {
        viewModelScope.launch {
            isLoading = true
            errorMessage = null
            try {
                val response = BisaMasakInstance.bisaMasakService.recipeContent()
                recipeList = response
            } catch (e: Exception) {
                errorMessage = e.localizedMessage
            } finally {
                isLoading = false
            }
        }
    }
}