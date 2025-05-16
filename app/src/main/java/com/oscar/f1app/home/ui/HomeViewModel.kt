package com.oscar.f1app.home.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.oscar.f1app.home.data.network.response.DriverResponse
import com.oscar.f1app.home.domain.HomeUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(private val homeUseCase: HomeUseCase): ViewModel(){


    private var _drivers = MutableLiveData<List<DriverResponse>?>();
    var drivers: LiveData<List<DriverResponse>?> = _drivers;

    init {
        getDrivers();
        Log.i("DRIVERS", "$_drivers")

    }


    fun getDrivers(){
        viewModelScope.launch {
            _drivers.value = homeUseCase.invoke();
        }
    }





}