package com.oscar.f1app.home.data

import com.oscar.f1app.home.data.network.HomeService
import com.oscar.f1app.home.data.network.response.DriverResponse
import javax.inject.Inject

class HomeRepository @Inject constructor(private val service: HomeService){


    suspend fun getDrivers(): List<DriverResponse>?{
        return service.getDrivers();
    }
}