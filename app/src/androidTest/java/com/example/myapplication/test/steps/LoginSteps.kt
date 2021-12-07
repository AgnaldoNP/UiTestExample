package com.example.myapplication.test.steps

import android.util.Log
import androidx.test.core.app.ActivityScenario
import com.example.myapplication.test.util.assertActivityIsOpened
import com.example.myapplication.test.util.runAssert
import com.example.myapplication.ui.login.LoginActivity
import io.cucumber.java.en.Given

class LoginSteps {

    private lateinit var loginActivity: ActivityScenario<LoginActivity>

    @Given("^Que eu abra a tela login$")
    fun openLoginActivity() {
        loginActivity = ActivityScenario.launch(LoginActivity::class.java)
        runAssert { assertActivityIsOpened<LoginActivity>() }
    }

    @Given("^Que eu insira o email \"(.*)\" e senha \"(.*)\"$")
    fun insertLoginData(email: String, password: String) {
        loginActivity.onActivity {
            with(it.getViewBiding()) {
                etEmail.setText(email)
                etPassword.setText(password)
            }
        }
    }
}
