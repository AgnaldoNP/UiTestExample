package com.example.myapplication.test.di

import androidx.test.core.app.ApplicationProvider
import com.example.myapplication.domain.usecase.UserUseCase
import com.example.myapplication.test.MyApplicationTest
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
            single(override = true) { mockUserUseCase }
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
}
