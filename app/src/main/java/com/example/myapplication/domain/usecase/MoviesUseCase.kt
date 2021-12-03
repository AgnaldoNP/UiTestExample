package com.example.myapplication.domain.usecase

import com.example.myapplication.data.repository.MoviesRepository
import com.example.myapplication.domain.entity.Movie

class MoviesUseCase(
    private val repository: MoviesRepository
) {
    suspend fun search(): List<Pair<String, List<Movie>>> =
        repository.search()
            .groupBy { it.type }
            .map { map ->
                Pair(
                    map.key,
                    map.value.map {
                        Movie(
                            title = it.title,
                            description = it.description,
                            poster = it.poster,
                            imagesUrl = it.imagesUrl
                        )
                    }
                )
            }
}
