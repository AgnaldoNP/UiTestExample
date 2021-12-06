package com.example.myapplication.data.repository

import com.example.myapplication.data.source.local.PreferencesDataSource

class PreferencesRepository(
    private val preferences: PreferencesDataSource
) {
    fun rememberEmail(email: String) {
        preferences.rememberEmail(email)
    }

    fun getUserEmail(): String? {
        return preferences.getUserEmail()
    }

    fun saveUserEmail(email: String) {
        preferences.saveUserEmail(email)
    }
}
