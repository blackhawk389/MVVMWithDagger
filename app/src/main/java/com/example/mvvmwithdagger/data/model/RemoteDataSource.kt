package com.example.mvvmwithdagger.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface RemoteDataSource {
    fun getWeatherinfoFromRemote(city : String) : MutableLiveData<Remote>?
}