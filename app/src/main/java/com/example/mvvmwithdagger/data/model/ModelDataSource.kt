package com.example.mvvmwithdagger.data.model

import androidx.lifecycle.LiveData

interface ModelDataSource {
    fun getWeatherinfoFromLocalStorage(): Remote?
    fun getDatabaseCount() : Int
    fun updateWeatherInfo(item : Remote?) : Void
}