package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRequest(
    @Json(name = "device_id")
    val device_id: String,
    @Json(name = "fb_id")
    val fb_id: String,
    @Json(name = "page")
    val page: String,
    @Json(name = "token")
    val token: String,
    @Json(name = "type")
    val type: String
)