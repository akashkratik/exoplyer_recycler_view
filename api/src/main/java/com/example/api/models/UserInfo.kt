package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserInfo(
    @Json(name = "bio")
    val bio: String,
    @Json(name = "first_name")
    val firstName: String,
    @Json(name = "gender")
    val gender: String,
    @Json(name = "profile_pic")
    val profilePic: String,
    @Json(name = "username")
    val username: String
)