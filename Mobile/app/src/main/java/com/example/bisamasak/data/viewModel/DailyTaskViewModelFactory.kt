package com.example.bisamasak.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.bisamasak.data.utils.DataStoreManager

class DailyTaskViewModelFactory(
    private val dataStoreManager: DataStoreManager
) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(DailyTaskViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return DailyTaskViewModel(dataStoreManager) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}