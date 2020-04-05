package com.example.mvvmwithdagger.data

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource
import java.util.*
import kotlin.concurrent.schedule

class RepositoryImpl(val modelDataSource : ModelDataSource,
                     val remoteDataSource: RemoteDataSource
) : IRepository{
    override fun getDatabaseCount(): Int {
        return modelDataSource.getDatabaseCount()
    }

    override fun saveData(item : LiveData<Remote>) {
        modelDataSource.updateWeatherInfo(
            remoteDataSource.getWeatherinfoFromRemote("karachi") as Remote)
    }


    override fun getWeatherinfoFromRemote(city: String): Remote? {
        var data = remoteDataSource.getWeatherinfoFromRemote(city)
        Timer("SettingUp", false).schedule(20000) {
            modelDataSource.updateWeatherInfo(data)
        }
        return data;
    }

    override fun getWeatherinfoFromLocalStorage(): Remote? {
        return modelDataSource.getWeatherinfoFromLocalStorage()
    }

    override fun updateWeatherInfo(item: Remote?) : Void {
        return modelDataSource.updateWeatherInfo(item)
    }

    override fun filterData() : Remote?{
        var count = getDatabaseCount()
        if(count > 0){
            return getWeatherinfoFromLocalStorage()
        }else{
            return getWeatherinfoFromRemote("karachi")
        }
    }

}