package com.example.mvvmwithdagger.data

import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource
import com.example.mvvmwithdagger.data.remote.APIEndPoints
import com.example.mvvmwithdagger.data.remote.RetrofitObject
import com.example.mvvmwithdagger.util.ApiConstant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.util.*
import javax.inject.Singleton
import kotlin.concurrent.schedule

@Singleton
class RepositoryImpl(val modelDataSource : ModelDataSource,
                     val remoteDataSource: RemoteDataSource
) : IRepository {

    override fun getDatabaseCount(): Int {
        return modelDataSource.getDatabaseCount()
    }

    override fun saveData(item : LiveData<Remote>) {
        modelDataSource.updateWeatherInfo(
            remoteDataSource.getWeatherinfoFromRemote("karachi") as Remote)
    }


    override fun getWeatherinfoFromRemote(city: String): MutableLiveData<Remote>? {
//        var data = remoteDataSource.getWeatherinfoFromRemote(city)
//            modelDataSource.updateWeatherInfo(data)
//
//        return data;
        var mutableLiveData : MutableLiveData<Remote>? = MutableLiveData()
        val service = RetrofitObject.getClient()?.create(APIEndPoints::class.java)
        val call = service?.getWeatherUpdate(city, ApiConstant.apikey)

        call?.enqueue(object : Callback<Remote> {
            override fun onResponse(call: Call<Remote>, response: Response<Remote>) {
                if (response.isSuccessful) {
                    modelDataSource.updateWeatherInfo(response.body())
                    mutableLiveData?.postValue(response.body())
                    //have some callback ^
                }
            }

            override fun onFailure(call: Call<Remote>, t: Throwable) {
                mutableLiveData?.postValue(null)
            }
        })

        return mutableLiveData
    }

    override fun getWeatherinfoFromLocalStorage(): LiveData<Remote>? {
        return modelDataSource.getWeatherinfoFromLocalStorage()
    }

    override fun updateWeatherInfo(item: Remote?) : Void {
        return modelDataSource.updateWeatherInfo(item)
    }

    override fun getData() : LiveData<Remote>?{
        var count = getDatabaseCount()
        if(count > 0){
            return getWeatherinfoFromLocalStorage()
        }else{
            return getWeatherinfoFromRemote("karachi")
        }
    }

}