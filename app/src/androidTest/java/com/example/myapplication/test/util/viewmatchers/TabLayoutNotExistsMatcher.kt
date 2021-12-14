package com.example.myapplication.test.util.viewmatchers

import com.google.android.material.tabs.TabLayout
import org.hamcrest.Description

class TabLayoutNotExistsMatcher(private val text: String) : TabLayoutMatcher(text) {

    override fun describeTo(description: Description?) {
        description?.appendText("TabLayoutNotExistsMatcher $text")
    }

    override fun matchesSafely(tabLayout: TabLayout?): Boolean {
        return !super.matchesSafely(tabLayout)
    }
}
