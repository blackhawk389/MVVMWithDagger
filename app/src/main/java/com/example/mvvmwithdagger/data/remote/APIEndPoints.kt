package com.example.mvvmwithdagger.data.remote

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.Remote
import retrofit2.http.GET
import retrofit2.http.Query
import java.util.*

interface APIEndPoints {

    @GET()
    fun getWeatherUpdate(@Query("q") city :String
                         , @Query("appid")  id : String)
                         : LiveData<Remote>
}