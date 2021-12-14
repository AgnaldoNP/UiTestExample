package com.example.myapplication.test.datafactory

import com.example.myapplication.data.source.remote.entity.MovieApiResponse

private const val MOVIE = "movie"
private const val SERIES = "series"

fun mockOnlyMovies() = listOf(
    MovieApiResponse(
        type = MOVIE,
        title = "Movie 1",
        year = "2000",
        genre = "Aventura",
        description = "description",
        poster = "http://ia.media-imdb.com/images/M/MV5BMTU2MTQwMjU1OF5BMl5BanBnXkFtZTgwMDA5NjU5ODE@._V1_SX300.jpg",
        imagesUrl = listOf(
            "https://images-na.ssl-images-amazon.com/images/M/MV5BN2EyYzgyOWEtNTY2NS00NjRjLWJiNDYtMWViMjg5MWZjYjgzXkEyXkFqcGdeQXVyNjUwNzk3NDc@._V1_.jpg"
        )
    ),
    MovieApiResponse(
        type = MOVIE,
        title = "Movie 2",
        year = "2001",
        genre = "Terror",
        description = "description",
        poster = "http://ia.media-imdb.com/images/M/MV5BMTcyMzc1MjI5MF5BMl5BanBnXkFtZTgwMzE4ODY2OTE@._V1_SX300.jpg",
        imagesUrl = listOf(
            "https://images-na.ssl-images-amazon.com/images/M/MV5BMjMyNjg5ODYwNF5BMl5BanBnXkFtZTgwMTE1NDU4OTE@._V1_SY1000_CR0,0,1477,1000_AL_.jpg"
        )
    )
)
