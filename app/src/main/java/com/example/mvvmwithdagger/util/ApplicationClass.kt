package com.example.mvvmwithdagger.util

import android.app.Application
import android.content.Context

class ApplicationClass : Application() {


    init {
        context = this
    }


    override fun onCreate() {
        super.onCreate()
        context = this
    }

    companion object{
        lateinit var context : Context
        fun getApplicationClassContext() : Context {
            return context.applicationContext
        }
    }
}