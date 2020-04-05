package com.example.mvvmwithdagger.ui.weather_info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.mvvmwithdagger.data.IRepository

class WeatherInforViewModelFactory(val repo : IRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return WeatherInfoViewModel(repo) as T
    }
}