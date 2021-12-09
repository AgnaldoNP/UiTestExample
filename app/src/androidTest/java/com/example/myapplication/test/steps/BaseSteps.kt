package com.example.myapplication.test.steps

import androidx.test.espresso.matcher.ViewMatchers
import com.adevinta.android.barista.assertion.BaristaVisibilityAssertions.assertDisplayed
import com.adevinta.android.barista.interaction.BaristaDialogInteractions
import com.adevinta.android.barista.internal.assertAny
import com.example.myapplication.test.di.DiTestManager
import com.example.myapplication.test.util.ActivityFinisher
import com.example.myapplication.test.util.delayedClickOnButton
import com.example.myapplication.test.util.runAssert
import com.example.myapplication.test.util.viewmatchers.TextInputErrorStateMatcher
import io.cucumber.java.After
import io.cucumber.java.Before
import io.cucumber.java.en.And
import org.koin.java.KoinJavaComponent.inject

class BaseSteps {

    private val diManager by inject<DiTestManager>(DiTestManager::class.java)

    @Before
    fun before() {
        diManager.clearMocks()
    }

    @After
    fun tearDown() {
        ActivityFinisher.finishOpenActivities()
    }

    @And("^Eu (?:clique|clicar) no botão \"(.*)\"$")
    fun clickLogin(buttonText: String) {
        runAssert { delayedClickOnButton(buttonText) }
    }

    @And("^Eu (?:vejo|verei) o texto \"([^\"]*)\"$")
    fun checkTxtOnScreen(text: String) {
        runAssert { assertDisplayed(text) }
    }

    @And("^Eu (?:vejo|verei) no campo a mensagem de erro \"(.*)\"$")
    fun checkErrorEditTextOnScreen(errorMessage: String) {
        runAssert {
            TextInputErrorStateMatcher(errorMessage)
                .assertAny(ViewMatchers.isDisplayed())
        }
    }

    @And("^Eu (?:vejo|verei) a mensagem no popup \"(.*)\"$")
    fun checkErrorOnScreen(message: String) {
        runAssert {
            runAssert { assertDisplayed(message) }
            BaristaDialogInteractions.clickDialogPositiveButton()
        }
    }
}
