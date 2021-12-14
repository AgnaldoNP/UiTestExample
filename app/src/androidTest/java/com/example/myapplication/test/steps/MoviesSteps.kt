package com.example.myapplication.test.steps

import com.example.myapplication.test.robot.MoviesRobot
import com.example.myapplication.test.util.runAssert
import io.cucumber.java.en.Given
import io.cucumber.java.en.Then
import io.cucumber.java.en.When

class MoviesSteps {

    private val moviesRobot = MoviesRobot()

    @Then("^Eu verei a tab \"(.*)\"$")
    fun assertTabVisibility(tabName: String) {
        runAssert { moviesRobot.assertTabVisible(tabName) }
    }

    @Then("^Eu não verei a tab \"(.*)\"$")
    fun assertTabNotVisible(tabName: String) {
        runAssert { moviesRobot.assertTabNotVisible(tabName) }
    }

    @Then("^Eu verei a tab \"(.*)\" selecionada$")
    fun verifyIsTabIsSelected(tabName: String) {
        runAssert { moviesRobot.assertTabSelected(tabName) }
    }

    @When("^Eu clicar no primeiro filme$")
    fun clickFirstMovie() {
        runAssert { moviesRobot.clickFirstMovie() }
    }

    @Given("^Que a busca por titulos retorne apenas filmes$")
    fun mockOnlyMovies() {
        runAssert { moviesRobot.mockOnlyMovies() }
    }
}
