package com.example.bisamasak.data.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.example.bisamasak.data.dataContainer.Pengguna
import com.example.bisamasak.data.dataContainer.Users
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.firstOrNull
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {

    companion object {
        private val ONBOARDING_SHOW = booleanPreferencesKey("onboarding_show")
        private val IS_LOGIN = booleanPreferencesKey("is_login")
        private val LAST_ACTIVE = longPreferencesKey("last_active")
        private val LAST_LOGIN_DATE = stringPreferencesKey("last_login_date")
        private val USER_ID = longPreferencesKey("user_id")
        private val USER_NAME = stringPreferencesKey("user_name")
        private val USER_EMAIL = stringPreferencesKey("user_email")
        private val USER_BIRTHDATE = stringPreferencesKey("user_birthdate")
        private val USER_GENDER = stringPreferencesKey("user_gender")
        private val USER_PHOTO = stringPreferencesKey("user_photo")
        private val USER_LEVEL = longPreferencesKey("user_level")
        private val USER_POINT = longPreferencesKey("user_point")
        private val LOGIN_MISSION_DATE = stringPreferencesKey("login_mission_claimed_date")
        private val RECIPE_MISSION_CLAIMED_DATE = stringPreferencesKey("recipe_mission_claimed_date")
        private val UPLOAD_RECIPE_CLAIMED_KEY = stringPreferencesKey("upload_recipe_claimed_date")
    }

//    Onboarding State
    suspend fun setOnboardingShow(show: Boolean) {
        context.dataStore.edit { preferences ->
            preferences[ONBOARDING_SHOW] = show
        }
    }

    suspend fun isOnboardingShow(): Boolean {
        return context.dataStore.data
            .map { it[ONBOARDING_SHOW] ?: false }
            .first()
    }

//    Login State
    suspend fun setLogin(login: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGIN] = login
        }
    }

    suspend fun isLogin(): Boolean {
        return context.dataStore.data
            .map { it[IS_LOGIN] ?: false }
            .first()
    }

    suspend fun setLastLoginDate(date: String) {
        context.dataStore.edit { prefs ->
            prefs[LAST_LOGIN_DATE] = date
        }
    }

    suspend fun getLastLoginDate(): String? {
        return context.dataStore.data
            .map { it[LAST_LOGIN_DATE] }
            .first()
    }

    suspend fun isLogout() {
        context.dataStore.edit { prefs ->
            prefs[IS_LOGIN] = false
        }
    }

    suspend fun setLastActive(time: Long) {
        context.dataStore.edit { prefs ->
            prefs[LAST_ACTIVE] = time
        }
    }

    suspend fun getLastActive(): Long {
        return context.dataStore.data
            .map { it[LAST_ACTIVE] ?: 0L }
            .first()
    }

//    User State
    suspend fun setUserName(name: String) {
        context.dataStore.edit { prefs ->
            prefs[USER_NAME] = name
        }
    }

    suspend fun getUserName(): String {
        return context.dataStore.data
            .map { it[USER_NAME] ?: "" }
            .first()
    }

    suspend fun setUserId(id: Long) {
        context.dataStore.edit { prefs ->
            prefs[USER_ID] = id
        }
    }

    suspend fun getUserId(): Long {
        return context.dataStore.data
            .map { it[USER_ID] ?: -1L }
            .first()
    }

    private fun viewedRecipeKey(userId: Long) = stringPreferencesKey("viewed_recipes_user_$userId")

    suspend fun setViewedRecipe(userId: Long, recipeId: Int) {
        val key = viewedRecipeKey(userId)
        context.dataStore.edit { prefs ->
            val current = prefs[key] ?: ""
            val list = current.split(",")
                .filter { it.isNotBlank() && it != recipeId.toString() }
                .toMutableList()

            list.add(0, recipeId.toString())
            if (list.size > 15) list.removeAt(list.lastIndex)

            prefs[key] = list.joinToString(",")
        }
    }

    suspend fun getViewedRecipeIds(userId: Long): List<Int> {
        val key = viewedRecipeKey(userId)
        return context.dataStore.data
            .map { prefs ->
                prefs[key]
                    ?.split(",")
                    ?.filter { it.isNotBlank() }
                    ?.mapNotNull { it.toIntOrNull() }
                    ?: emptyList()
            }
            .first()
    }

    suspend fun setUser(user: Users) {
        context.dataStore.edit { prefs ->
            prefs[USER_ID] = user.id
            prefs[USER_NAME] = user.nama
            prefs[USER_EMAIL] = user.email
            prefs[USER_BIRTHDATE] = user.tanggalLahir ?: ""
            prefs[USER_GENDER] = user.jenisKelamin ?: ""
            prefs[USER_PHOTO] = user.fotoProfil ?: ""
        }
    }

    suspend fun getUser(): Users? {
        return context.dataStore.data.map { prefs ->
            val id = prefs[USER_ID] ?: return@map null
            val nama = prefs[USER_NAME] ?: ""
            val email = prefs[USER_EMAIL] ?: ""
            val birthdate = prefs[USER_BIRTHDATE]
            val gender = prefs[USER_GENDER]
            val photo = prefs[USER_PHOTO]

            Users(
                id = id,
                nama = nama,
                email = email,
                tanggalLahir = birthdate,
                jenisKelamin = gender,
                fotoProfil = photo
            )
        }.first()
    }

//    Daily Task
    suspend fun setUserLevel(level: Int) {
        context.dataStore.edit { prefs ->
            prefs[USER_LEVEL] = level.toLong()
        }
    }

    suspend fun getUserLevel(): Int {
        return context.dataStore.data
            .map { it[USER_LEVEL]?.toInt() ?: 1 }
            .first()
    }

    suspend fun setUserPoint(point: Int) {
        context.dataStore.edit { prefs ->
            prefs[USER_POINT] = point.toLong()
        }
    }

    suspend fun getUserPoint(): Int {
        return context.dataStore.data
            .map { it[USER_POINT]?.toInt() ?: 0 }
            .first()
    }

    suspend fun setLoginMissionClaimed(date: String) {
        context.dataStore.edit { prefs ->
            prefs[LOGIN_MISSION_DATE] = date
        }
    }

    suspend fun getLoginMissionClaimed(): String? {
        return context.dataStore.data
            .map { it[LOGIN_MISSION_DATE] }
            .firstOrNull()
    }

    suspend fun setRecipeMissionClaimed(date: String) {
        context.dataStore.edit { prefs ->
            prefs[RECIPE_MISSION_CLAIMED_DATE] = date
        }
    }

    suspend fun getRecipeMissionClaimed(): String {
        return context.dataStore.data
            .map { it[RECIPE_MISSION_CLAIMED_DATE] ?: "" }
            .first()
    }

    suspend fun getUploadRecipeMissionClaimed(): String {
        return context.dataStore.data
            .map { it[UPLOAD_RECIPE_CLAIMED_KEY] ?: "" }
            .first()
    }

    suspend fun setUploadRecipeMissionClaimed(date: String) {
        context.dataStore.edit { prefs -> prefs[UPLOAD_RECIPE_CLAIMED_KEY] = date }
    }

    val userLevelFlow = context.dataStore.data
        .map { it[USER_LEVEL]?.toInt() ?: 1 }

    val userPointFlow = context.dataStore.data
        .map { it[USER_POINT]?.toInt() ?: 0 }
}