package com.example.myapplication.ui.main

import com.example.myapplication.domain.usecase.MoviesUseCase
import com.example.myapplication.ui.base.BaseViewModel

class MainViewModel(
    private val moviesUseCase: MoviesUseCase
) : BaseViewModel()
