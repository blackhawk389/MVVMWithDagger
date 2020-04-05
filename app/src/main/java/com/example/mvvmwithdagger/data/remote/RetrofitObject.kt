package com.example.mvvmwithdagger.data.remote

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.util.ApiConstant
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitObject {
    companion object{
        private var retrofit : Retrofit? = null

        fun getClient() : Retrofit?{
             retrofit = Retrofit.Builder().baseUrl(ApiConstant.baseUrl)
                .addConverterFactory(GsonConverterFactory.create()).build()

            return retrofit
        }
    }
}