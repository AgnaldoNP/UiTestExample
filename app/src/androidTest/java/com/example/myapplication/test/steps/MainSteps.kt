package com.example.myapplication.test.steps

import com.example.myapplication.test.robot.HomeRobot
import com.example.myapplication.test.util.runAssert
import io.cucumber.java.en.Then

class MainSteps {

    private val homeRobot = HomeRobot()

    @Then("^Eu verei a tela home$")
    fun checkMainActivity() {
        runAssert { homeRobot.assertHomeActivityIsOpened() }
    }

    @Then("^Que eu abra a tela home sem estar estar logado$")
    fun openLoggedOutMainActivity() {
        homeRobot.apply {
            setupKoinMockForHomeLoggedOutTest()
            launchMainActivity()
        }
    }

    @Then("^Que eu abra a tela home com usuário logado$")
    fun openLoggedInMainActivity() {
        homeRobot.apply {
            setupKoinMockForHomeLoggedInTest()
            launchMainActivity()
        }
    }
}
