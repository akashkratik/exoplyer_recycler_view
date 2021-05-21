package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Msg(
    @Json(name = "count")
    val count: Count,
    @Json(name = "fb_id")
    val fbId: String,
    @Json(name = "gif")
    val gif: String,
    @Json(name = "id")
    val id: String,
    @Json(name = "is_block")
    val liked: String,
    @Json(name = "sound")
    val sound: Sound,
    @Json(name = "thum")
    val thum: String,
    @Json(name = "user_info")
    val userInfo: UserInfo,
    @Json(name = "video")
    val video: String
)