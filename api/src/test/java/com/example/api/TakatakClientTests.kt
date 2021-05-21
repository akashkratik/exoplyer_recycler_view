package com.example.api

import com.example.api.models.UserRequest
import org.junit.Assert.assertEquals
import org.junit.Assert.assertNotNull
import kotlinx.coroutines.runBlocking
import org.junit.Test

class TakatakClientTests {

    private val takatakClient = TakatakClient()

    @Test
    fun `POST videoRequest`(){
        val userRequest = UserRequest(
            fb_id = "0",
            token = "eynBsaVYwIE:APA91bEmLkA0mold83uPz1N570IZjPGwAUE_o93EkDCPjSZ5-sQRxKRRwAEsSpiGvEOFMq06XQxrCx0k1Kbh8GVjYr3OmDjSGikCiJCReVGsM4-hHvPWgYMOaFrP-9HaO1JfWDg7PgZV",
            page = "4",
            device_id = "af37ba10f52bca24",
            type = "related"
        )
        runBlocking {
            val dataResponse = takatakClient.api.videoRequest("showAllVideos", userRequest)
            assertEquals("200", dataResponse.body()?.code )
            assertNotNull(dataResponse.body()?.msg)
        }
    }

}