package com.example.myapplication.test.steps

import com.example.myapplication.test.robot.HomeRobot
import com.example.myapplication.test.util.assertActivityIsOpened
import com.example.myapplication.test.util.runAssert
import com.example.myapplication.ui.main.MainActivity
import io.cucumber.java.en.Then

class MainSteps {

    private val homeRobot = HomeRobot()

    @Then("^Eu verei a tela home$")
    fun checkMainActivity() {
        runAssert { assertActivityIsOpened<MainActivity>() }
    }

    @Then("^Que eu abra a tela home sem estar estar logado$")
    fun openMainActivity() {
        homeRobot.apply {
            setupKoinMockForHomeLoggedOutTest()
            launchMainActivity()
        }
    }
}
