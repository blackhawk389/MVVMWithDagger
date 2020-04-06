package com.example.mvvmwithdagger.ui.weather_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithdagger.data.IRepository
import com.example.mvvmwithdagger.data.model.Remote
import java.util.*
import kotlin.concurrent.schedule

class WeatherInfoViewModel(val repo : IRepository): ViewModel() {



    var mutableLiveData : MutableLiveData<Remote>? = MutableLiveData()


    fun getWeatherReport() : MutableLiveData<Remote>?{
      return repo.getWeatherinfoFromRemote("London,uk")
    }

    fun getMutableData() : LiveData<Remote>?{
        return repo.getData()
    }



}