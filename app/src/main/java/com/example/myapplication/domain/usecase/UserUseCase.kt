package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.UserRepository

open class UserUseCase(
    private val userRepository: UserRepository
) {
    open fun isUserLogged(): Boolean {
        return !userRepository.getUserEmail().isNullOrEmpty()
    }

    fun saveUserEmail(email: String) {
        userRepository.saveUserEmail(email)
    }
}
