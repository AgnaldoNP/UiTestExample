package com.example.myapplication.test.steps

import com.example.myapplication.test.robot.LoginRobot
import com.example.myapplication.test.util.runAssert
import io.cucumber.java.en.Given

class LoginSteps {

    private val loginRobot = LoginRobot()

    @Given("^Eu verei a tela de login$")
    fun checkLoginActivity() {
        runAssert { loginRobot.assertLoginActivityIsOpened() }
    }

    @Given("^Que eu abra a tela login$")
    fun openLoginActivity() {
        loginRobot.launchLoginActivity()
        runAssert { loginRobot.assertLoginActivityIsOpened() }
    }

    @Given("^Que eu insira o email \"(.*)\" e senha \"(.*)\"$")
    fun insertLoginData(email: String, password: String) {
        loginRobot.insertLoginData(email, password)
    }
}
