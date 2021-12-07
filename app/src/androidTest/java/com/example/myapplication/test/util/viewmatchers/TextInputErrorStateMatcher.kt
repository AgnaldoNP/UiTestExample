package com.example.myapplication.test.util.viewmatchers

import android.view.View
import android.widget.EditText
import androidx.test.espresso.matcher.BoundedMatcher
import org.hamcrest.Description

class TextInputErrorStateMatcher(private val errorText: String) :
    BoundedMatcher<View, EditText>(EditText::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("TextInputErrorStateMatcher $errorText")
    }

    override fun matchesSafely(editText: EditText?): Boolean {
        editText?.error?.toString()?.let {
            return@matchesSafely it == errorText
        }
        return false
    }
}
