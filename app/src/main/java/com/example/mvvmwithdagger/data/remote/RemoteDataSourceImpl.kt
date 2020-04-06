package com.example.mvvmwithdagger.data.remote

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource
import com.example.mvvmwithdagger.util.ApiConstant
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class RemoteDataSourceImpl : RemoteDataSource {
    var mutableLiveData : MutableLiveData<Remote>? = null

    override fun getWeatherinfoFromRemote(city: String): MutableLiveData<Remote>? {
        val service = RetrofitObject.getClient()?.create(APIEndPoints::class.java)
        val call = service?.getWeatherUpdate(city, ApiConstant.apikey)

        call?.enqueue(object : Callback<Remote> {
            override fun onResponse(call: Call<Remote>, response: Response<Remote>) {
                if (response.isSuccessful) {
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


}