package com.example.mvvmwithdagger.data.model

import androidx.lifecycle.LiveData

interface RemoteDataSource {
    fun getWeatherinfoFromRemote(city : String) : Remote?
}