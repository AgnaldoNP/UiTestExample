package com.example.myapplication.test.util.viewmatchers.actions

import android.view.View
import androidx.test.espresso.UiController
import androidx.test.espresso.ViewAction
import org.hamcrest.Matcher

class DelayedClickAction(
    private val viewMatcher: Matcher<View>,
    private val delay: Long
) : ViewAction {
    override fun getDescription() = "Wait for $delay milliseconds to perform click."

    override fun getConstraints() = viewMatcher

    override fun perform(uiController: UiController?, view: View?) {
        if (uiController != null && view != null) {
            uiController.loopMainThreadForAtLeast(delay)
            view.performClick()
        }
    }
}
