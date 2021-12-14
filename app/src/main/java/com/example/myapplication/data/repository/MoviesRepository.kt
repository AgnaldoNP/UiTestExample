package com.example.myapplication.data.repository

import com.example.myapplication.data.source.remote.api.MoviesApi
import com.example.myapplication.data.source.remote.entity.MovieApiResponse

class MoviesRepository(
    private val moviesApi: MoviesApi
) {
    suspend fun search(): List<MovieApiResponse> = moviesApi.search()
}
