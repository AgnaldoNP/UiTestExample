package com.example.myapplication.data.repository

class UserRepository(
    private val preferences: PreferencesRepository
) {
    fun getUserEmail(): String? {
        return preferences.getUserEmail()
    }

    fun saveUserEmail(email: String) {
        preferences.saveUserEmail(email)
    }
}
