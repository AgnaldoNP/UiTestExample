package com.example.myapplication.data.source.remote.api

import com.example.myapplication.data.source.remote.entity.MovieApiResponse
import retrofit2.http.GET

interface MoviesApi {
    @GET("/saniyusuf/406b843afdfb9c6a86e25753fe2761f4/raw/523c324c7fcc36efab8224f9ebb7556c09b69a14/Film.JSON")
    suspend fun search(): List<MovieApiResponse>
}
