package com.example.myapplication.test

import com.example.myapplication.application.MyApplication
import com.example.myapplication.test.di.DiTestManager
import org.koin.core.context.loadKoinModules
import org.koin.dsl.module

class MyApplicationTest : MyApplication() {

    override fun onCreate() {
        super.onCreate()
        setupTestDependencies()
    }

    fun setupApplicationDependencies() {
        super.setupInjector()
    }

    fun setupTestDependencies() {
        loadKoinModules(
            module {
                single { DiTestManager() }
            }
        )
    }
}
