package com.example.api.models


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Count(
    @Json(name = "like_count")
    val likeCount: String,
    @Json(name = "video_comment_count")
    val videoCommentCount: String
)