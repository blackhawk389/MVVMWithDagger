package com.example.mvvmwithdagger.data.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitObject {
    companion object{
        private var retrofit : Retrofit? = null

        fun getClient() : Retrofit?{
             retrofit = Retrofit.Builder().baseUrl("")
                .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }
    }
}