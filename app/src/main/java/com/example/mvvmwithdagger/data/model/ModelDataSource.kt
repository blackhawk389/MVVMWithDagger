package com.example.mvvmwithdagger.data.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

interface ModelDataSource {
    fun getWeatherinfoFromLocalStorage(): LiveData<Remote>?
    fun getDatabaseCount() : Int
    fun updateWeatherInfo(item : Remote?) : Void
}