package com.oscar.f1app.home.data.network

import com.oscar.f1app.home.data.network.response.DriverResponse
import retrofit2.Response
import retrofit2.http.GET

interface HomeClient {

    @GET("drivers?session_key=9158")
    suspend fun getDrivers(): Response<List<DriverResponse>>;
}