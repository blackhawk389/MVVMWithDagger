package com.example.mvvmwithdagger.util

import androidx.room.TypeConverter
import com.example.mvvmwithdagger.data.model.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainTypeConverter {
    companion object {
        @TypeConverter
        @JvmStatic
        fun fromSys(value: Main): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun  stringToApp(string: String): Main {
            return Gson().fromJson(string, Main::class.java)
        }
        @TypeConverter
        @JvmStatic
        fun fromWind(value: Wind): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun  stringToWind(string: String): Wind {
            return Gson().fromJson(string, Wind::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromcoords(value: Coord): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun  stringToCoords(string: String): Coord {
            return Gson().fromJson(string, Coord::class.java)
        }

        @TypeConverter
        @JvmStatic
        fun fromclouds(value: Clouds): String {
            return Gson().toJson(value)
        }

        @TypeConverter
        @JvmStatic
        fun  stringToclouds(string: String): Clouds {
            return Gson().fromJson(string, Clouds::class.java)
        }
        @TypeConverter
        @JvmStatic
        fun fromWeatherList(value: List<Weather>): String {
            val type = object : TypeToken<List<Weather>>() {}.type
            return Gson().toJson(value, type)
        }

        @TypeConverter
        @JvmStatic
        fun  stringToWeatherList(string: String): List<Weather> {
            val type = object : TypeToken<List<Weather>>() {}.type
            return Gson().fromJson(string, type)
        }

    }
}