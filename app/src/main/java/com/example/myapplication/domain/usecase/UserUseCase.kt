package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.UserRepository

class UserUseCase(
    private val userRepository: UserRepository
) {
    fun isUserLogged(): Boolean {
        return !userRepository.getUserEmail().isNullOrEmpty()
    }

    fun saveUserEmail(email: String) {
        userRepository.saveUserEmail(email)
    }
}
