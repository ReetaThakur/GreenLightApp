package com.example.greenlightapp.repository

import com.example.greenlightapp.database.ItemDao
import com.example.greenlightapp.database.ItemTable
import com.example.greenlightapp.response.*
import javax.inject.Inject

class Repository @Inject constructor() {

    val apiCall = Network.getRetrofit().create(ApiService::class.java)


    suspend fun getApiData():ResponseDTO{
        return apiCall.getService()
    }

//    fun insertItem(list:ArrayList<ItemTable>){
//        itemDao.addListOfItems(list)
//    }
//
//    fun deleteItem(){
//        itemDao.delete()
//    }


}