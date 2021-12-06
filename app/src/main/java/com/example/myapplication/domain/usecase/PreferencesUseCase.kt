package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.PreferencesRepository

class PreferencesUseCase(
    private val repository: PreferencesRepository
) {
    fun rememberEmail(email: String) {
        repository.rememberEmail(email)
    }
}
