package com.example.api.services

import com.example.api.models.DataResponse
import com.example.api.models.UserRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST
import retrofit2.http.Query


interface TakatakApi {


    @POST("index.php?p")
    suspend fun videoRequest(
        @Query ("p") p : String? = null,
        @Body userRequest: UserRequest
    ): Response<DataResponse>


}