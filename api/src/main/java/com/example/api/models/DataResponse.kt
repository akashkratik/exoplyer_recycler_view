package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class DataResponse(
    @Json(name = "code")
    val code: String,
    @Json(name = "msg")
    val msg: List<Msg>
)