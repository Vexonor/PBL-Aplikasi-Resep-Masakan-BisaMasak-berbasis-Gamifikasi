package com.example.bisamasak.data.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.bisamasak.data.dataContainer.TaskItemData
import com.example.bisamasak.data.utils.DataStoreManager
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.example.bisamasak.R
import com.example.bisamasak.data.instance.BisaMasakInstance
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

class DailyTaskViewModel(private val dataStoreManager: DataStoreManager) : ViewModel() {
    private val _taskList = MutableStateFlow<List<TaskItemData>>(emptyList())
    val taskList: StateFlow<List<TaskItemData>> = _taskList

    private val _userPoint = MutableStateFlow(0)
    val userPoint: StateFlow<Int> = _userPoint

    private val _idUser = MutableStateFlow(-1L)
    val idUser: StateFlow<Long> = _idUser

    private val _userLevel = MutableStateFlow(1)
    val userLevel: StateFlow<Int> = _userLevel

    init {
        viewModelScope.launch {
            val id = dataStoreManager.getUserId()
            _idUser.value = id

            val point = dataStoreManager.getUserPoint()
            _userPoint.value = point

            val level = dataStoreManager.getUserLevel()
            _userLevel.value = level

            _taskList.value = listOf(
                TaskItemData(R.drawable.ic_coin, "Login hari ini", 200),
                TaskItemData(R.drawable.ic_coin, "Baca resep", 300),
                TaskItemData(R.drawable.ic_coin, "Unggah resep", 500)
            )
            checkLoginMissionClaimed()
        }
    }

    fun getMaxExp(level: Int): Int {
        val baseExp = 1000
        val increment = 500
        return baseExp + (level - 1) * increment
    }

    fun checkLoginMissionClaimed() {
        viewModelScope.launch {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = sdf.format(Date())
            val claimedDate = dataStoreManager.getLoginMissionClaimed()
            val isClaimedToday = claimedDate == today

            val newList = _taskList.value.map {
                if (it.title == "Login hari ini") it.copy(isClaimed = isClaimedToday) else it
            }
            _taskList.value = newList
        }
    }

    fun checkReadRecipeMissionClaimed() {
        viewModelScope.launch {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = sdf.format(Date())
            val claimedDate = dataStoreManager.getRecipeMissionClaimed()
            val isClaimedToday = claimedDate == today

            val newList = _taskList.value.map {
                if (it.title == "Baca resep") it.copy(isClaimed = isClaimedToday) else it
            }
            _taskList.value = newList
        }
    }

    fun checkUploadRecipeMissionClaimed() {
        viewModelScope.launch {
            val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
            val today = sdf.format(Date())
            val claimedDate = dataStoreManager.getUploadRecipeMissionClaimed()
            val isClaimedToday = claimedDate == today

            val newList = _taskList.value.map {
                if (it.title == "Unggah resep") it.copy(isClaimed = isClaimedToday) else it
            }
            _taskList.value = newList
        }
    }

    fun claimTaskPoints(task: TaskItemData) {
        if (task.isClaimed) return
        viewModelScope.launch {
            val currentId = _idUser.value
            var currentLevel = _userLevel.value
            val currentPoint = _userPoint.value

            val totalPoint = currentPoint + task.points
            var maxExp = getMaxExp(currentLevel)
            var remainingExp = totalPoint

            while (remainingExp >= maxExp) {
                remainingExp -= maxExp
                currentLevel++
                maxExp = getMaxExp(currentLevel)
            }
            val body = mapOf(
                "poin_level" to remainingExp,
                "level_pengguna" to currentLevel
            )

            try {
                val pengguna =
                    BisaMasakInstance.bisaMasakService.updateLevelPengguna(currentId, body)

                _userLevel.value = pengguna.levelPengguna.coerceAtLeast(1)
                _userPoint.value = pengguna.poinLevel.toInt()
                dataStoreManager.setUserLevel(_userLevel.value)
                dataStoreManager.setUserPoint(_userPoint.value)
            } catch (e: Exception) {
                e.localizedMessage
            }

            if (task.title == "Login hari ini") {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val today = sdf.format(Date())
                dataStoreManager.setLoginMissionClaimed(today)
            }

            if (task.title == "Baca resep") {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val today = sdf.format(Date())
                dataStoreManager.setRecipeMissionClaimed(today)
            }

            if (task.title == "Unggah resep") {
                val sdf = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
                val today = sdf.format(Date())
                dataStoreManager.setUploadRecipeMissionClaimed(today)
            }

            _taskList.value = _taskList.value.map {
                if (it.title == task.title) it.copy(isClaimed = true) else it
            }

        }
    }
}