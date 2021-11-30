package com.example.myapplication.di

import com.example.myapplication.domain.usecase.MoviesUseCase
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single { MoviesUseCase(repository = get()) }
    }
}
