package com.example.bisamasak.data.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.instance.RetrofitInstance.wikipediaApiEn
import com.example.bisamasak.data.utils.formatIngredientName
import kotlinx.coroutines.launch

class WikipediaViewModel : ViewModel() {
    private val _description = MutableStateFlow<String?>(null)
    val ingredientDescription: StateFlow<String?> = _description

    fun fetchIngredientDescription(title: String) {
        val formattedTitle = formatIngredientName(title)

        viewModelScope.launch {
            try {
                val responseEn = wikipediaApiEn.getSummary(formattedTitle)
                _description.value = responseEn.extract ?: "Deskripsi Tidak Tersedia"
            } catch (e: Exception) {
                _description.value = "Deskripsi Tidak Tersedia"
                Log.d("Wikipedia", "Gagal mendapatkan deskripsi: ${e.message}")
            }
        }
    }
}