package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Sound(
    @Json(name = "audio_path")
    val audioPath: AudioPath,
    @Json(name = "description")
    val description: String,
    @Json(name = "id")
    val id: Any?,
    @Json(name = "sound_name")
    val soundName: Any?,
)