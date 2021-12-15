package com.example.myapplication.data.source.remote.api

import com.example.myapplication.data.source.remote.entity.MovieApiResponse
import retrofit2.http.GET

interface MoviesApi {
    @GET("/AgnaldoNP/UiTestExample/master/resource_json/films.json")
    suspend fun search(): List<MovieApiResponse>
}
