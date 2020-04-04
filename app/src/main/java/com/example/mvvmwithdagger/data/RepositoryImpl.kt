package com.example.mvvmwithdagger.data

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource

class RepositoryImpl(val modelDataSource : ModelDataSource,
                     val remoteDataSource: RemoteDataSource
) : IRepository{


    override fun getWeatherinfoFromRemote(city: String): LiveData<Remote> {
            return remoteDataSource.getWeatherinfoFromRemote(city)
    }

    override fun getWeatherinfoFromLocalStorage(): LiveData<Remote> {
        return modelDataSource.getWeatherinfoFromLocalStorage()
    }

    override fun updateWeatherInfo(item: Remote) {
        modelDataSource.updateWeatherInfo(item)
    }

    override fun filterData() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}