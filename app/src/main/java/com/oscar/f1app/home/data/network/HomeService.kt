package com.oscar.f1app.home.data.network

import com.oscar.f1app.home.data.network.response.DriverResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.Retrofit
import javax.inject.Inject

class HomeService @Inject constructor(private val homeClient: HomeClient){


    suspend fun getDrivers(): List<DriverResponse>? {
        return withContext(Dispatchers.IO){
           val response = homeClient.getDrivers();
            response.body();
        }
    }


}