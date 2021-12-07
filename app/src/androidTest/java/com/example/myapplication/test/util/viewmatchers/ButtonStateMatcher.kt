package com.example.myapplication.test.util.viewmatchers

import android.view.View
import android.widget.Button
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class ButtonStateMatcher(private val text: String, private val enabled: Boolean) :
    BoundedMatcher<View, Button>(Button::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("ButtonStateMatcher $text")
    }

    override fun matchesSafely(button: Button?): Boolean {
        button?.text?.toString()?.let {
            return@matchesSafely it.trim() == text.trim() && button.isEnabled == enabled
        }
        return false
    }
}
