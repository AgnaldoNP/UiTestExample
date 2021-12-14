package com.example.myapplication.test.robot

import androidx.test.core.app.ActivityScenario
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.test.util.assertActivityIsOpened
import com.example.myapplication.test.util.runAssert
import com.example.myapplication.ui.login.LoginActivity

class LoginRobot : BaseRobot<LoginActivity, ActivityLoginBinding>() {

    fun launchLoginActivity() {
        ActivityScenario.launch(LoginActivity::class.java)
        runAssert { assertActivityIsOpened<LoginActivity>() }
    }

    fun insertLoginData(email: String, password: String) {
        getActivityViewBinding {
            it.apply {
                etEmail.setText(email)
                etPassword.setText(password)
            }
        }
    }

    fun assertLoginActivityIsOpened() {
        assertActivityIsOpened<LoginActivity>()
    }
}
