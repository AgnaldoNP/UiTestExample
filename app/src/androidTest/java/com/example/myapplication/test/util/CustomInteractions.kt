package com.example.myapplication.test.util

import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.matcher.ViewMatchers.withText
import com.adevinta.android.barista.internal.performAction
import com.adevinta.android.barista.internal.util.resourceMatcher
import com.example.myapplication.test.util.viewmatchers.ButtonMatcher
import com.example.myapplication.test.util.viewmatchers.actions.DelayedClickAction

private const val DEFAULT_DELAY_ACTION = 300L

fun delayedClickOn(resId: Int, delay: Long = DEFAULT_DELAY_ACTION) =
    resId.resourceMatcher().apply {
        performAction(DelayedClickAction(this, delay))
    }

fun delayedClickOn(text: String, delay: Long = DEFAULT_DELAY_ACTION) =
    withText(text).apply {
        performAction(DelayedClickAction(this, delay))
    }

fun clickOnButton(text: String) =
    ButtonMatcher(text).performAction(ViewActions.click())

fun delayedClickOnButton(text: String, delay: Long = DEFAULT_DELAY_ACTION) {
    val viewMatcher = ButtonMatcher(text)
    viewMatcher.performAction(DelayedClickAction(viewMatcher, delay))
}
