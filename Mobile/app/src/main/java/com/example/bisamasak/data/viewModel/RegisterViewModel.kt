package com.example.bisamasak.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.RegisterRequest
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.launch

class RegisterViewModel : ViewModel() {
    var responseMessage by mutableStateOf("")

    fun register(nama: String, email: String, password: String) {
        viewModelScope.launch {
            try {
                val request = RegisterRequest(nama, email, password)
                val response = BisaMasakInstance.bisaMasakService.registerUser(request)
                if (response.isSuccessful) {
                    responseMessage = response.body()?.message ?: "Success"
                } else {
                    responseMessage = "Register Failed: ${response.code()}"
                }
            } catch (e: Exception) {
                responseMessage = "Error: ${e.localizedMessage}"
            }
        }
    }
}