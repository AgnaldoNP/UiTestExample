package com.example.myapplication.data.repository

class LoginRepository {
    suspend fun login(email: String, password: String) {
        // TODO implement API login
        if (email == "a@a.com") {
            throw Exception("email not valid")
        }
    }
}
