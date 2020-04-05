package com.example.mvvmwithdagger.data

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource

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


    override fun getWeatherinfoFromRemote(city: String): LiveData<Remote> {
        var data = remoteDataSource.getWeatherinfoFromRemote(city)
        modelDataSource.updateWeatherInfo(data as Remote)
        return data;
    }

    override fun getWeatherinfoFromLocalStorage(): LiveData<Remote> {
        return modelDataSource.getWeatherinfoFromLocalStorage()
    }

    override fun updateWeatherInfo(item: Remote) : Int {
        return modelDataSource.updateWeatherInfo(item)
    }

    override fun filterData() : LiveData<Remote>{
        var count = getDatabaseCount()
        if(count > 0){
            return getWeatherinfoFromLocalStorage()
        }else{
            return getWeatherinfoFromRemote("karachi")
        }
    }

}