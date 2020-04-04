package com.example.mvvmwithdagger.data.model

import androidx.lifecycle.LiveData

interface ModelDataSource {
    fun getWeatherinfoFromLocalStorage(): LiveData<Remote>
    fun updateWeatherInfo(item : Remote) : Unit
}