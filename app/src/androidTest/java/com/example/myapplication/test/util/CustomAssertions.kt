package com.example.myapplication.test.util

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.doesNotExist
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.platform.app.InstrumentationRegistry.getInstrumentation
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import com.adevinta.android.barista.internal.assertAny
import com.example.myapplication.test.util.viewmatchers.ButtonStateMatcher
import org.junit.Assert

fun assertButtonState(text: String, enabled: Boolean) =
    ButtonStateMatcher(text, enabled).assertAny(ViewMatchers.isDisplayed())

fun assertNotExist(resId: Int) {
    onView(withId(resId)).check(doesNotExist())
}

inline fun <reified A> assertActivityIsOpened() {
    var activityIsOpen = false
    val activityClassName = A::class.java.name

    getInstrumentation().runOnMainSync {
        activityIsOpen = ActivityLifecycleMonitorRegistry
            .getInstance()
            .getActivitiesInStage(Stage.RESUMED)
            .elementAtOrNull(0)?.javaClass?.name == activityClassName
    }

    Assert.assertTrue(activityIsOpen)
}
