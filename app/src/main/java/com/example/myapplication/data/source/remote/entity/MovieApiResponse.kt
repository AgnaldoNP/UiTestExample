package com.example.myapplication.data.source.remote.entity

import com.google.gson.annotations.SerializedName

data class MovieApiResponse(
    @SerializedName("Type")
    val type: String,
    @SerializedName("Title")
    val title: String,
    @SerializedName("Plot")
    val description: String,
    @SerializedName("Poster")
    val poster: String,
    @SerializedName("Images")
    val imagesUrl: List<String>
)
