package com.oscar.f1app.home.domain

import com.oscar.f1app.home.data.HomeRepository
import com.oscar.f1app.home.data.network.response.DriverResponse

class HomeUseCase {

    val homeRepository = HomeRepository();

    suspend operator fun invoke(): List<DriverResponse>?{
        return homeRepository.getDrivers();
    }
}