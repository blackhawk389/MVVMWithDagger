package com.example.mvvmwithdagger.ui.weather_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithdagger.data.IRepository
import com.example.mvvmwithdagger.data.model.Remote

class WeatherInfoViewModel(val repo : IRepository): ViewModel() {

    var mutableLiveData : MutableLiveData<Remote>? =null

    fun getWeatherReport() : Remote?{
        mutableLiveData!!.postValue(return repo.getWeatherinfoFromRemote("london"))
    }

    init{
        repo.filterData()
    }

    fun getMutableData() : MutableLiveData<Remote>?{
        return mutableLiveData
    }



}