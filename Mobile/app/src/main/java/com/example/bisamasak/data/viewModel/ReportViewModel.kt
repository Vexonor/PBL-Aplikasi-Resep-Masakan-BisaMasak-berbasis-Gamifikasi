package com.example.bisamasak.data.viewModel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.ReportResponse
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.launch

class ReportViewModel : ViewModel() {

    var isLoading by mutableStateOf(false)
    var isSuccess by mutableStateOf(false)
    var errorMessage by mutableStateOf<String?>(null)

    fun createReport(id_resep: Int, deskripsi_laporan: String) {
        viewModelScope.launch {
            isLoading = true
            isSuccess = false
            errorMessage = null

            try {
                val request = ReportResponse(
                    id_resep = id_resep,
                    deskripsi_laporan = deskripsi_laporan
                )
                val response = BisaMasakInstance.bisaMasakService.reportContent(request)

                if (response.isSuccessful) {
                    isSuccess = true
                } else {
                    val errorBody = response.errorBody()?.string()

                    errorMessage = if (errorBody?.contains("<html>") == true || errorBody?.contains("<script>") == true) {
                        "Terjadi kesalahan pada server. Silakan coba lagi."
                    } else {
                        "Gagal Mengirim Laporan (${response.code()})"
                    }

                    Log.e("LaporanViewModel", "Error body: $errorBody")
                }
            } catch (e: Exception) {
                errorMessage = e.localizedMessage ?: "Terjadi Kesalahan"
                Log.e("LaporanViewModel", "Exception: ${e.message}")
            } finally {
                isLoading = false
            }
        }
    }

    fun resetStatus() {
        isSuccess = false
        errorMessage = null
    }
}