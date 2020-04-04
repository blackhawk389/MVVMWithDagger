package com.example.mvvmwithdagger.data.local

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.OnConflictStrategy.REPLACE
import androidx.room.Query
import androidx.room.Update
import com.example.mvvmwithdagger.data.model.Remote

@Dao
interface WeatherDao {

    @Query("SELECT * from city_weather")
    fun getWeatherInfo() : LiveData<Remote>

    @Update(onConflict = REPLACE)
    fun updateWeatherInfo(obj : Remote) : Boolean
}