package com.example.bisamasak.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.Pengguna
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UsersViewModel : ViewModel() {
    private val _pengguna = MutableStateFlow<Pengguna?>(null)
    val pengguna: StateFlow<Pengguna?> = _pengguna

    fun fetchPengguna(idUser: Long) {
        viewModelScope.launch {
            try {
                val result = BisaMasakInstance.bisaMasakService.getPengguna(idUser)
                _pengguna.value = result
            } catch (e: Exception) {
                e.localizedMessage
                _pengguna.value = null
            }
        }
    }

    fun updateLevelAndPoints(idUser: Long, newLevel: Int, newPoint: Int) {
        viewModelScope.launch {
            try {
                val body = mapOf(
                    "poin_level" to newPoint,
                    "level_pengguna" to newLevel
                )
                val updateUser = BisaMasakInstance.bisaMasakService.updateLevelPengguna(idUser, body)
                _pengguna.value = updateUser
            } catch (e: Exception) {
                e.localizedMessage
            }
        }
    }
}