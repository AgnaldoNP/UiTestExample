package com.example.myapplication.di

import com.example.myapplication.BuildConfig
import com.example.myapplication.data.source.remote.api.MoviesApi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkModule {
    val networkModule = module {
        single {
            Retrofit
                .Builder()
                .baseUrl(BuildConfig.API_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(
                    OkHttpClient().newBuilder()
                        .addNetworkInterceptor(
                            HttpLoggingInterceptor().apply {
                                level = HttpLoggingInterceptor.Level.BODY
                            }
                        ).build()
                ).build()
        }

        // API injections
        single {
            inject<Retrofit>().value.create(MoviesApi::class.java)
        }
    }
}
