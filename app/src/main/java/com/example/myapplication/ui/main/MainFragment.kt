package com.example.myapplication.ui.main

import android.os.Bundle
import android.view.View
import androidx.lifecycle.LifecycleOwner
import com.example.myapplication.databinding.FragmentMainBinding
import com.example.myapplication.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainFragment : BaseFragment<FragmentMainBinding, MainViewModel>() {

    override val viewModel: MainViewModel by viewModel()
    override fun inflateRoot(): View = FragmentMainBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = FragmentMainBinding.bind(view)

    override fun initUI(viewBinding: FragmentMainBinding) {
        super.initUI(viewBinding)
    }

    override fun initObservers(lifecycleOwner: LifecycleOwner, viewBinding: FragmentMainBinding) {
        super.initObservers(lifecycleOwner, viewBinding)
    }

    override fun initViewModel(savedInstanceState: Bundle?) {
        super.initViewModel(savedInstanceState)
    }
}
