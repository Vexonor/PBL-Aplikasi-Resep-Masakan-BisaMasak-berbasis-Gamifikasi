package com.example.bisamasak.data.viewModel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.CommentResponse
import com.example.bisamasak.data.dataContainer.CommentStore
import com.example.bisamasak.data.instance.BisaMasakInstance
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter
import java.time.Duration

class CommentViewModel : ViewModel() {

    private val commentService = BisaMasakInstance.bisaMasakService

    private val _comments = MutableStateFlow<List<CommentResponse>>(emptyList())
    val comments: StateFlow<List<CommentResponse>> = _comments

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    private val _isSuccess = MutableStateFlow(false)
    val isSuccess: StateFlow<Boolean> = _isSuccess

    private val _errorMessage = MutableStateFlow<String?>(null)
    val errorMessage: StateFlow<String?> = _errorMessage

    private var currentRecipeId: Int? = null

    fun loadCommentsByRecipeId(recipeId: Int) {
        currentRecipeId = recipeId
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = commentService.getCommentsByRecipeId(recipeId)
                _comments.value = response
            } catch (e: Exception) {
                Log.e("CommentVM", "Error loading comments: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun storeComment(comment: CommentStore) {
        viewModelScope.launch {
            _isLoading.value = true
            _isSuccess.value = false
            _errorMessage.value = null
            Log.d("DEBUG_COMMENT", "Kirim komentar: $comment")

            try {
                val response = BisaMasakInstance.bisaMasakService.storeComment(comment)

                if (response.isSuccessful) {
                    _isSuccess.value = true
                    loadCommentsByRecipeId(comment.id_resep)
                } else {
                    val errorBody = response.errorBody()?.string()
                    _errorMessage.value = if (errorBody?.contains("<html>") == true) {
                        "Terjadi kesalahan server"
                    } else {
                        "Gagal mengirim komentar (${response.code()})"
                    }
                    Log.e("CommentViewModel", "Error body: $errorBody")
                }
            } catch (e: Exception) {
                _errorMessage.value = e.localizedMessage ?: "Terjadi Kesalahan"
                Log.e("CommentViewModel", "Exception: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun deleteComment(id: Int) {
        viewModelScope.launch {
            _isLoading.value = true
            try {
                val response = commentService.deleteComment(id)
                if (response.isSuccessful) {
                    currentRecipeId?.let { loadCommentsByRecipeId(it) }
                } else {
                    Log.e("CommentVM", "Delete failed: ${response.code()}")
                }
            } catch (e: Exception) {
                Log.e("CommentVM", "Error deleting comment: ${e.message}")
            } finally {
                _isLoading.value = false
            }
        }
    }
    fun resetStatus() {
        _isSuccess.value = false
        _errorMessage.value = null
    }
}
