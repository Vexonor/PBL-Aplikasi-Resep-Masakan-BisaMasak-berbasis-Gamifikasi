package com.example.bisamasak.data.utils

import java.time.LocalDate
import java.time.ZoneId
import java.time.ZonedDateTime
import java.time.format.DateTimeFormatter

fun createdToday(createdAt: String?): Boolean {
    if (createdAt == null) return false

    return try {
        val zone = ZonedDateTime.parse(createdAt, DateTimeFormatter.ISO_OFFSET_DATE_TIME)
        val recipeDate = zone.withZoneSameInstant(ZoneId.systemDefault()).toLocalDate()
        val today = LocalDate.now()
        recipeDate == today
    } catch (e: Exception) {
        e.localizedMessage
        false
    }
}