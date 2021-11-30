package com.example.myapplication.di

import com.example.myapplication.data.repository.MoviesRepository
import org.koin.dsl.module

object RepositoryModule {
    val repositoryModule = module {
        factory {
            MoviesRepository(
                moviesApi = get(),
            )
        }
    }
}
