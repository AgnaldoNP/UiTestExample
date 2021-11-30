package com.example.myapplication.di

import com.example.myapplication.ui.main.MainViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

object ViewModelModule {
    val viewModelModule = module {
        viewModel { MainViewModel(get()) }
    }
}