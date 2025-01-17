package com.example.mvvmwithdagger.ui.weather_info

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithdagger.data.IRepository
import com.example.mvvmwithdagger.data.model.Remote

class WeatherInfoViewModel(val repo : IRepository): ViewModel() {

    fun getWeatherReport() : LiveData<Remote>{
        return repo.filterData()
    }



}