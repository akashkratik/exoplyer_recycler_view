package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AudioPath(
    @Json(name = "acc")
    val acc: String,
    @Json(name = "mp3")
    val mp3: String
)