package com.example.myapplication.test.util.viewmatchers

import android.view.View
import androidx.test.espresso.matcher.BoundedMatcher
import com.google.android.material.tabs.TabLayout
import org.hamcrest.Description

class TabLayoutStateMatcher(private val text: String, private val selected: Boolean) :
    BoundedMatcher<View, TabLayout>(TabLayout::class.java) {

    override fun describeTo(description: Description?) {
        description?.appendText("TabLayoutStateMatcher $text selected: $selected")
    }

    override fun matchesSafely(tabLayout: TabLayout?): Boolean {
        tabLayout?.let {
            for (i in 0 until tabLayout.tabCount) {
                tabLayout.getTabAt(i)?.let { tab ->
                    if (tab.isSelected == selected &&
                        tab.text?.toString()?.equals(text, true) == true
                    ) {
                        return@matchesSafely true
                    }
                }
            }
        }
        return false
    }
}
