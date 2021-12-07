package com.example.myapplication.application

import android.app.Application
import com.example.myapplication.di.DomainModule.domainModule
import com.example.myapplication.di.NetworkModule.networkModule
import com.example.myapplication.di.RepositoryModule.repositoryModule
import com.example.myapplication.di.ViewModelModule.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.loadKoinModules
import org.koin.core.context.startKoin

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()
        setupInjector()
    }

    fun setupInjector() {
        startKoin {
            androidLogger()
            androidContext(this@MyApplication)
            loadKoinModules(getModules())
        }
    }

    companion object {
        fun getModules() = listOf(
            networkModule,
            repositoryModule,
            domainModule,
            viewModelModule
        )
    }
}
