package com.example.bisamasak.data.viewModel

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.instance.BisaMasakInstance
import com.example.bisamasak.data.utils.DataStoreManager
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class ProfileViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {

    var isLoading = mutableStateOf(false)
    var responseMessage = mutableStateOf("")
    var isSuccess = mutableStateOf(false)

    fun updateProfile(
        idUser: Long,
        nama: String,
        email: String,
        tanggalLahir: String?,
        jenisKelamin: String?,
        password: String?,
        photoFile: File?,
        onPasswordUpdated: () -> Unit
    ) {
        viewModelScope.launch {
            isLoading.value = true
            responseMessage.value = ""
            isSuccess.value = false

            try {
                val namaBody = nama.toRequestBody("text/plain".toMediaTypeOrNull())
                val emailBody = email.toRequestBody("text/plain".toMediaTypeOrNull())
                val tanggalLahirBody = tanggalLahir?.toRequestBody("text/plain".toMediaTypeOrNull())
                val jenisKelaminBody = jenisKelamin?.toRequestBody("text/plain".toMediaTypeOrNull())
                val passwordBody = password?.toRequestBody("text/plain".toMediaTypeOrNull())

                val photoPart = photoFile?.let {
                    val reqFile = it.asRequestBody("image/*".toMediaTypeOrNull())
                    MultipartBody.Part.createFormData("foto_profil", it.name, reqFile)
                }

                val response = BisaMasakInstance.bisaMasakService.updateProfile(
                    userId = idUser,
                    nama = namaBody,
                    tanggalLahir = tanggalLahirBody,
                    jenisKelamin = jenisKelaminBody,
                    email = emailBody,
                    password = passwordBody,
                    fotoProfil = photoPart
                )

                if (response.isSuccessful && response.body() != null) {
                    val user = response.body()!!.user
                    responseMessage.value = "Profile berhasil diupdate"
                    isSuccess.value = true

                    dataStoreManager.setUser(user)

                    if (password != null && password.isNotEmpty()) {
                        onPasswordUpdated()
                    }
                } else {
                    responseMessage.value = response.errorBody()?.string() ?: "Gagal update profile"
                }
            } catch (e: Exception) {
                responseMessage.value = "Error: ${e.localizedMessage}"
            } finally {
                isLoading.value = false
            }
        }
    }

}