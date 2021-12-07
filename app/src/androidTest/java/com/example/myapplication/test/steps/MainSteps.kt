package com.example.myapplication.test.steps

import com.example.myapplication.test.util.assertActivityIsOpened
import com.example.myapplication.test.util.runAssert
import com.example.myapplication.ui.main.MainActivity
import io.cucumber.java.en.Then

class MainSteps {

    @Then("^Eu verei a tela home$")
    fun openLoginActivity() {
        runAssert { assertActivityIsOpened<MainActivity>() }
    }
}
