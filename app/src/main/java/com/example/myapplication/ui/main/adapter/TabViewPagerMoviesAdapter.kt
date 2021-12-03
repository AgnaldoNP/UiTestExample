package com.example.myapplication.ui.main.adapter

import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter

class TabViewPagerMoviesAdapter(
    fragmentManager: FragmentManager,
    lifecycle: Lifecycle,
    private val fragments: List<TabAdapterMoviesFragment>
) : FragmentStateAdapter(fragmentManager, lifecycle) {
    override fun getItemCount() = fragments.size
    override fun createFragment(position: Int) = fragments[position]
    fun getTabTitle(position: Int): String = fragments[position].getTabTitle()
}
