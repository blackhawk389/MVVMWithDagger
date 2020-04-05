package com.example.mvvmwithdagger.data

import androidx.lifecycle.LiveData
import com.example.mvvmwithdagger.data.model.ModelDataSource
import com.example.mvvmwithdagger.data.model.Remote
import com.example.mvvmwithdagger.data.model.RemoteDataSource

interface IRepository : ModelDataSource, RemoteDataSource{
   fun filterData() : Remote?
   fun saveData(item : LiveData<Remote>)
}