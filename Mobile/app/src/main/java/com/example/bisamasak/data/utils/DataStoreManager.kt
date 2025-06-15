package com.example.bisamasak.data.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map

private val Context.dataStore by preferencesDataStore(name = "settings")

class DataStoreManager(private val context: Context) {

    companion object {
        private val ONBOARDING_SHOW = booleanPreferencesKey("onboarding_show")
        private val IS_LOGIN = booleanPreferencesKey("is_login")
        private val LAST_ACTIVE = longPreferencesKey("last_active")
        private val USER_ID = longPreferencesKey("user_id")
        private val USER_NAME = stringPreferencesKey("user_name")
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
}