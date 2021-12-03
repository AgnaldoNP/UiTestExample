package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.main.adapter.TabAdapterMoviesFragment
import com.example.myapplication.ui.main.adapter.TabViewPagerMoviesAdapter
import com.google.android.material.tabs.TabLayoutMediator
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    override fun inflateRoot(): View = FragmentMainBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = FragmentMainBinding.bind(view)

    private lateinit var tabAdapter: TabViewPagerMoviesAdapter

    override fun initViewModel(savedInstanceState: Bundle?) {
        super.initViewModel(savedInstanceState)
        viewModel.getMovies()
    }

    override fun initUI(viewBinding: FragmentMainBinding) {
        super.initUI(viewBinding)
        tabAdapter = TabViewPagerMoviesAdapter(
            childFragmentManager,
            viewLifecycleOwner.lifecycle,
            listOf()
        )
        viewBinding.viewPagerType.adapter = tabAdapter
    }

    override fun initObservers(lifecycleOwner: LifecycleOwner, viewBinding: FragmentMainBinding) {
        super.initObservers(lifecycleOwner, viewBinding)
        viewModel.moviesLiveEvent.observe(lifecycleOwner) { groups ->
            tabAdapter = TabViewPagerMoviesAdapter(
                childFragmentManager,
                viewLifecycleOwner.lifecycle,
                groups.map { group ->
                    val (type, movies) = group
                    TabAdapterMoviesFragment(type, movies)
                }
            )
            viewBinding.viewPagerType.adapter = tabAdapter
            TabLayoutMediator(viewBinding.tabLayout, viewBinding.viewPagerType) { tab, position ->
                tab.text = tabAdapter.getTabTitle(position)
            }.attach()
        }
    }
}
