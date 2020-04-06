package com.example.mvvmwithdagger.data.local

import androidx.annotation.IntegerRes
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.mvvmwithdagger.data.model.Remote

@Dao
interface WeatherDao {

    @Query("SELECT * from city_weather")
    fun getWeatherInfo() : LiveData<Remote>?

    @Query("SELECT count(*) from city_weather")
    fun getDatabaseCount() : Int

    @Insert(onConflict = REPLACE)
    fun updateWeatherInfo(obj : Remote?) : Void
}