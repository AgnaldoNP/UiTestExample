package com.example.myapplication.test.steps

import com.example.myapplication.test.robot.MoviesRobot
import com.example.myapplication.test.util.runAssert
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class MoviesSteps {

    private val moviesRobot = MoviesRobot()

    @Then("^Eu verei a tab \"(.*)\"$")
    fun assertTabVisibility(tabName: String) {
        runAssert { moviesRobot.assertTabVisibility(tabName) }
    }

    @Then("^Eu verei a tab \"(.*)\" selecionada$")
    fun verifyIsTabIsSelected(tabName: String) {
        runAssert { moviesRobot.assertTabSelected(tabName) }
    }

    @When("^Eu clicar no primeiro filme$")
    fun clickFirstMovie() {
        runAssert { moviesRobot.clickFirstMovie() }
    }
}
