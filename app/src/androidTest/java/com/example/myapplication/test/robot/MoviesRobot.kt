package com.example.myapplication.test.robot

import androidx.test.espresso.matcher.ViewMatchers
import com.adevinta.android.barista.interaction.BaristaListInteractions
import com.adevinta.android.barista.internal.assertAny
import com.example.myapplication.R
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.test.di.DiTestManager
import com.example.myapplication.test.util.viewmatchers.TabLayoutMatcher
import com.example.myapplication.test.util.viewmatchers.TabLayoutNotExistsMatcher
import com.example.myapplication.test.util.viewmatchers.TabLayoutStateMatcher
import com.example.myapplication.ui.main.MainFragment
import org.koin.java.KoinJavaComponent.inject

class MoviesRobot : BaseFragmentRobot<MainFragment, FragmentMainBinding>() {

    private val diManager by inject<DiTestManager>(DiTestManager::class.java)

    fun assertTabVisible(tabName: String) {
        TabLayoutMatcher(tabName).assertAny(ViewMatchers.isDisplayed())
    }

    fun assertTabNotVisible(tabName: String) {
        TabLayoutNotExistsMatcher(tabName).assertAny(ViewMatchers.isDisplayed())
//        BaristaVisibilityAssertions.assertNotDisplayed(TabLayoutGoneMatcher(tabName))
    }

    fun assertTabSelected(tabName: String) {
        TabLayoutStateMatcher(tabName, true).assertAny(ViewMatchers.isDisplayed())
    }

    fun clickFirstMovie() {
        BaristaListInteractions.clickListItem(R.id.recyclerView, 0)
    }

    fun mockOnlyMovies() {
        diManager.setupKoinMockForOnlyMovies()
    }
}
