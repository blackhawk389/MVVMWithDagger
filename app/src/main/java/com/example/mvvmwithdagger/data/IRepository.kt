package com.example.mvvmwithdagger.data

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource

interface IRepository : ModelDataSource, RemoteDataSource{
   fun getData() : LiveData<Remote>?
   fun saveData(item : LiveData<Remote>)
}