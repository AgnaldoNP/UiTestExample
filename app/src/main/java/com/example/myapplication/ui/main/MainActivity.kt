package com.example.myapplication.ui.main

import android.view.View
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.ui.base.BaseActivity
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : BaseActivity<ActivityMainBinding, MainViewModel>() {
    override val viewModel: MainViewModel by viewModel()
    override fun inflateRoot(): View = ActivityMainBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = ActivityMainBinding.bind(view)
}
