package com.example.greenlightapp.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.greenlightapp.database.ItemDao
import com.example.greenlightapp.database.ItemTable
import com.example.greenlightapp.repository.Repository
import com.example.greenlightapp.response.ApiService
import com.example.greenlightapp.ui.MainUiModel
import javax.inject.Inject

class CountryViewModel ():ViewModel() {

    val repository=Repository()

    val mutableLiveData = MutableLiveData<MainUiModel>()

    suspend fun callApi(){
        val responseDTO= repository.getApiData()
        if (responseDTO!=null)
            mutableLiveData.postValue(MainUiModel.Success(responseDTO))
        else
            mutableLiveData.postValue(MainUiModel.Failure("Error"))
    }

//    fun insertItem(list:ArrayList<ItemTable>){
//        repository.insertItem(list)
//    }
//
//    fun deleteItem(){
//        repository.deleteItem()
//    }



}