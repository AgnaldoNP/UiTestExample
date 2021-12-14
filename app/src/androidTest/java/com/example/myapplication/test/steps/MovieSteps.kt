package com.example.myapplication.test.steps

import com.example.myapplication.test.robot.MovieRobot
import com.example.myapplication.test.util.runAssert
import io.cucumber.java.en.Then

class MovieSteps {

    private val movieRobot = MovieRobot()

    @Then("^Eu verei a tela de detalhes do filme$")
    fun checkMovieFragment() {
        runAssert {
            movieRobot.assertMovieFragmentOpened()
        }
    }
}
