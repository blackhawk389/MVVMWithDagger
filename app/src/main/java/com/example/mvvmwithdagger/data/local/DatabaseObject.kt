package com.example.mvvmwithdagger.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.mvvmwithdagger.data.model.Remote

@Database(entities = [(Remote::class)], version = 1)
abstract class DatabaseObject : RoomDatabase() {

    abstract fun weatherDatabase(): WeatherDao

    companion object {
        private lateinit var INSTANCE: DatabaseObject

        fun getInstance(context: Context): DatabaseObject {
            if (::INSTANCE.isInitialized) {
                return INSTANCE
            }
            synchronized(this) {
                INSTANCE = Room.databaseBuilder(
                    context.applicationContext,

                    DatabaseObject::class.java, "weather_database"
                ).allowMainThreadQueries().build()

                return INSTANCE
            }
        }
    }

}