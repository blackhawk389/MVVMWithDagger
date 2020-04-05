package com.example.mvvmwithdagger.data.local

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.util.ApplicationClass

class LocalDataSourceImpl : ModelDataSource
{
    lateinit var dbInstance : WeatherDao
    init {
        dbInstance = DatabaseObject
            .getInstance(ApplicationClass.getApplicationClassContext()).weatherDatabase()
    }
    override fun getWeatherinfoFromLocalStorage(): Remote? {
        return dbInstance.getWeatherInfo()
    }

    override fun updateWeatherInfo(item: Remote?) : Void{
        return dbInstance.updateWeatherInfo(item)
    }

    override fun getDatabaseCount() : Int{
        return dbInstance.getDatabaseCount()
    }


}