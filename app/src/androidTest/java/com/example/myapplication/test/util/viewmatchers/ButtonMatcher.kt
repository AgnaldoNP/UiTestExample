package com.example.myapplication.test.util.viewmatchers

import android.view.View
import android.widget.Button
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

private const val NORMAL_SPACE_CHAR = 32.toChar()
private const val NON_BREAKING_SPACE_CHAR = 160.toChar()

class ButtonMatcher(private val text: String) :
    BoundedMatcher<View, Button>(Button::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("ButtonStateMatcher $text")
    }

    override fun matchesSafely(button: Button?): Boolean {
        button?.text?.toString()?.let {
            return@matchesSafely it.replaceNonBreakingSpaceChar()
                .trim() == text.replaceNonBreakingSpaceChar().trim()
        }
        return false
    }

    private fun String.replaceNonBreakingSpaceChar() =
        this.replace(NON_BREAKING_SPACE_CHAR, NORMAL_SPACE_CHAR)
}
