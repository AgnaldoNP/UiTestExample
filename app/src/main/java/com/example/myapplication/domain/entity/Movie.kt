package com.example.myapplication.domain.entity

data class Movie(
    val title: String,
    val description: String,
    val poster: String,
    val imagesUrl: List<String>
)
