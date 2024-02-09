package com.example.myapplication.test.di

import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.data.source.remote.api.MoviesApi
import com.example.myapplication.domain.usecase.UserUseCase
import com.example.myapplication.test.MyApplicationTest
import com.example.myapplication.test.datafactory.mockOnlyMovies
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import org.koin.core.context.loadKoinModules
import org.koin.core.context.stopKoin
import org.koin.core.context.unloadKoinModules
import org.koin.core.module.Module
import org.koin.dsl.module

class DiTestManager {

    private lateinit var moduleWithMocks: Module

    fun setupKoinMockForHomeLoggedOutTest() {
        val mockUserUseCase = mockk<UserUseCase> {
            every { isUserLogged() }.returns(false)
        }

        moduleWithMocks = module {
            single { mockUserUseCase }
        }
        loadKoinModules(moduleWithMocks)
    }

    fun setupKoinMockForHomeLoggedInTest() {
        val mockUserUseCase = mockk<UserUseCase> {
            every { isUserLogged() }.returns(true)
        }

        moduleWithMocks = module {
            single { mockUserUseCase }
        }
        loadKoinModules(moduleWithMocks)
    }

    fun clearMocks() {
        if (::moduleWithMocks.isInitialized) {
            unloadKoinModules(moduleWithMocks)
        }

        stopKoin()
        ApplicationProvider.getApplicationContext<MyApplicationTest>().apply {
            setupApplicationDependencies()
            setupTestDependencies()
        }
    }

    fun setupKoinMockForOnlyMovies() {
        val mockUserUseCase = mockk<UserUseCase> {
            every { isUserLogged() }.returns(true)
        }

        val mockMoviesApi = mockk<MoviesApi> {
            coEvery { search() }.coAnswers { mockOnlyMovies() }
        }

        moduleWithMocks = module {
            single { mockUserUseCase }
            factory { mockMoviesApi }
        }
        loadKoinModules(moduleWithMocks)
    }
}
