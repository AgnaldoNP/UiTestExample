package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.LoginRepository

class LoginUseCase(
    private val preferencesUseCase: PreferencesUseCase,
    private val loginRepository: LoginRepository,
    private val userUseCase: UserUseCase
) {
    suspend fun login(email: String, password: String, rememberEmail: Boolean): LoginStatus {
        when {
            email.isBlank() -> return LoginStatus.EMPTY_EMAIL
            password.isBlank() -> return LoginStatus.EMPTY_PASSWORD
            !email.contains("@") -> return LoginStatus.NO_EMAIL
            rememberEmail -> preferencesUseCase.rememberEmail(email)
        }

        return try {
            loginRepository.login(email, password)
            userUseCase.saveUserEmail(email)
            LoginStatus.SUCCESS
        } catch (e: Exception) {
            LoginStatus.LOGIN_REQUEST_FAIL
        }
    }

    enum class LoginStatus {
        SUCCESS,
        NO_EMAIL,
        EMPTY_EMAIL,
        EMPTY_PASSWORD,
        LOGIN_REQUEST_FAIL
    }
}
