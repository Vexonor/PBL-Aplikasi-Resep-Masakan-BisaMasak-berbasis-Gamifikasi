package com.example.bisamasak.data.dataContainer

import com.google.gson.annotations.SerializedName

data class TaskItemData(
    val iconResId: Int,
    val title: String,
    val points: Int,
    val isClaimed: Boolean = false
)

data class UpdateLevelRequest(
    @SerializedName("poin_level") val poinLevel: Int,
    @SerializedName("level_pengguna") val levelPengguna: Int
)
