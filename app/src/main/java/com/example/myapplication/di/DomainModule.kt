package com.example.myapplication.di

import com.example.myapplication.domain.usecase.LoginUseCase
import com.example.myapplication.domain.usecase.MoviesUseCase
import com.example.myapplication.domain.usecase.PreferencesUseCase
import com.example.myapplication.domain.usecase.UserUseCase
import org.koin.dsl.module

object DomainModule {
    val domainModule = module {
        single { MoviesUseCase(get()) }
        single { PreferencesUseCase(get()) }
        single { UserUseCase(get()) }
        single { LoginUseCase(get(), get(), get()) }
    }
}
