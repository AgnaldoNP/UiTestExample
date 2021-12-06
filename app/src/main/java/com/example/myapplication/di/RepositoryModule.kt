package com.example.myapplication.di

import com.example.myapplication.data.repository.LoginRepository
import com.example.myapplication.data.repository.MoviesRepository
import com.example.myapplication.data.repository.PreferencesRepository
import com.example.myapplication.data.repository.UserRepository
import com.example.myapplication.data.source.local.PreferencesDataSource
import org.koin.dsl.module

object RepositoryModule {
    val repositoryModule = module {
        single { PreferencesDataSource(context = get()) }

        factory { MoviesRepository(moviesApi = get()) }
        factory { PreferencesRepository(preferences = get()) }
        factory { UserRepository(preferences = get()) }
        factory { LoginRepository() }
    }
}
