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
    var isRegisterSuccess by mutableStateOf(false)
    var registerUserName by mutableStateOf("")

    fun register(nama: String, email: String, password: String, peran: String = "Pengguna") {
        viewModelScope.launch {
            try {
                val request = RegisterRequest(nama, email, password, peran)
                val response = BisaMasakInstance.bisaMasakService.registerUser(request)
                if (response.isSuccessful) {
                    responseMessage = response.body()?.message ?: "Success"
                    isRegisterSuccess = true
                    registerUserName = response.body()?.user?.nama ?: nama
                } else {
                    responseMessage = "Register Failed: ${response.code()}"
                }
            } catch (e: Exception) {
                responseMessage = "Error: ${e.localizedMessage}"
            }
        }
    }
}