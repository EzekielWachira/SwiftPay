package com.example.swiftpay.data.repository

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.emptyPreferences
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.map
import java.io.IOException

class PreferenceRepository(private val context: Context) {

    private val Context.dataStore: DataStore<Preferences>
            by preferencesDataStore(name = "swiftpay")

    private object PreferenceKeys {
        val isUserLoggedIn = booleanPreferencesKey("is_user_logged_in")
    }


    suspend fun saveUserLoggedInStatus(isUserLoggedIn: Boolean) {
        context.dataStore.edit { preference ->
            preference[PreferenceKeys.isUserLoggedIn] = isUserLoggedIn
        }
    }


    val isUserLoggedIn: Flow<Boolean> = context.dataStore.data
        .catch { exception ->
            if (exception is IOException) emit(emptyPreferences())
            else throw exception
        }.map { preferences ->
            preferences[PreferenceKeys.isUserLoggedIn] ?: false
        }


}