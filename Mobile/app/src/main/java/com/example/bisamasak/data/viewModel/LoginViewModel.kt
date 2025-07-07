package com.example.bisamasak.data.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.LoginRequest
import com.example.bisamasak.data.instance.BisaMasakInstance
import com.example.bisamasak.data.utils.DataStoreManager
import kotlinx.coroutines.launch

class LoginViewModel : ViewModel() {

    var responseMessage by mutableStateOf("")
    var isLoginSuccess by mutableStateOf(false)
    var isLoading by mutableStateOf(false)
    var loggedInUserName by mutableStateOf("")

    fun login(email: String, password: String, dataStoreManager: DataStoreManager) {
        viewModelScope.launch {
            isLoading = true
            responseMessage = ""
            isLoginSuccess = false

            try {
                val request = LoginRequest(email, password)
                val response = BisaMasakInstance.bisaMasakService.loginUser(request)
                if (response.isSuccessful) {
                    val user = response.body()?.user
                    loggedInUserName = response.body()?.user?.nama ?: ""
                    responseMessage = response.body()?.message ?: "login Success"
                    isLoginSuccess = true

                    user?.let {
                        dataStoreManager.setUserId(it.id.toLong())
                        dataStoreManager.setUser(it)
                        dataStoreManager.setLogin(true)
                    }
                } else {
                    responseMessage = "Gagal Melakukan Proses Masuk"
                }
            } catch (e: Exception) {
                responseMessage = "Error: ${e.localizedMessage}"
            } finally {
                isLoading = false
            }
        }
    }

    fun logout(dataStoreManager: DataStoreManager, onLogout: () -> Unit) {
        viewModelScope.launch {
            dataStoreManager.clearUserData()
            isLoginSuccess = false
            loggedInUserName = ""
            responseMessage = ""
            onLogout()
        }
    }

}