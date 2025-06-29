package com.example.bisamasak.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.RecipeContentResponse
import com.example.bisamasak.data.dataContainer.SaveRecipeRequest
import com.example.bisamasak.data.dataContainer.SavedRecipe
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SaveRecipeViewModel : ViewModel() {
    private val _isSaved = MutableStateFlow(false)
    val isSaved: StateFlow<Boolean> = _isSaved

    private val _savedRecipes = MutableStateFlow<List<SavedRecipe>>(emptyList())
    val savedRecipes: StateFlow<List<SavedRecipe>> = _savedRecipes

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    fun checkSaved(id_user: Int, idResep: Int) {
        viewModelScope.launch {
            try {
                val response = BisaMasakInstance.bisaMasakService.checkSaved(id_user, idResep)
                if (response.isSuccessful) {
                    val result = response.body()?.sudah_disimpan ?: false
                    _isSaved.value = result
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }


    fun saveRecipe(id_user: Int, idResep: Int) {
        viewModelScope.launch {
            try {
                val response = BisaMasakInstance.bisaMasakService.saveRecipe(SaveRecipeRequest(id_user, idResep))
                if (response.isSuccessful) {
                    _isSaved.value = true
                } else {
                    _errorMessage.value = response.message()
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun deleteSavedRecipe(id_user: Int, idResep: Int) {
        viewModelScope.launch {
            try {
                val response = BisaMasakInstance.bisaMasakService.deleteSavedRecipe(SaveRecipeRequest(id_user, idResep))
                if (response.isSuccessful) {
                    _isSaved.value = false
                } else {
                    _errorMessage.value = response.message()
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            }
        }
    }

    fun getSavedRecipes(id_user: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = BisaMasakInstance.bisaMasakService.getSavedRecipes(id_user)
                if (response.isSuccessful) {
                    _savedRecipes.value = response.body()?.data ?: emptyList()
                } else {
                    _errorMessage.value = response.message()
                }
            } catch (e: Exception) {
                _errorMessage.value = e.message
            } finally {
                _isLoading.value = false
            }
        }
    }
}
