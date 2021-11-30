package com.example.myapplication.data.source.remote.entity

import com.google.gson.annotations.SerializedName

data class MovieApiResponse(
    @SerializedName("Title")
    val title: String
)
