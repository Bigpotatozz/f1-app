package com.oscar.f1app.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.oscar.f1app.home.data.network.response.DriverResponse
import com.oscar.f1app.home.domain.HomeUseCase
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel(){

    private val homeUseCase = HomeUseCase();


    private var _drivers = MutableLiveData<List<DriverResponse>?>();
    var drivers: LiveData<List<DriverResponse>?> = _drivers;

    init {
        getDrivers();
        Log.i("DRIVERS", "$_drivers")

    }


    fun getDrivers(){
        viewModelScope.launch {
            _drivers.value = homeUseCase.invoke();

            verstappenDetector();
        }
    }

    fun verstappenDetector(){

       var driversModified =  _drivers.value!!.map {

            if(it.first_name == "Max"){
                it.copy(first_name = "Putote")
            }else{
                it
            }
        }


       _drivers.value = driversModified;
    }



}