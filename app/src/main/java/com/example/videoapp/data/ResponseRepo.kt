package com.example.videoapp.data

import com.example.api.TakatakClient
import com.example.api.models.UserRequest

object ResponseRepo {
    val api = TakatakClient().api

    private val userRequest = UserRequest(
        fb_id = "0",
        token = "eynBsaVYwIE:APA91bEmLkA0mold83uPz1N570IZjPGwAUE_o93EkDCPjSZ5-sQRxKRRwAEsSpiGvEOFMq06XQxrCx0k1Kbh8GVjYr3OmDjSGikCiJCReVGsM4-hHvPWgYMOaFrP-9HaO1JfWDg7PgZV",
        page = "4",
        device_id = "af37ba10f52bca24",
        type = "related"
    )
    suspend fun getVideosLink() = api.videoRequest("showAllVideos", userRequest)
}