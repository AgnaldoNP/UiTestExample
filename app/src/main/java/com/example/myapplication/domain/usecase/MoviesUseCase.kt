package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.MoviesRepository

class MoviesUseCase(
    private val repository: MoviesRepository
)
