package com.example.greenlightapp.ui

import com.example.greenlightapp.response.ResponseDTO

sealed class MainUiModel(){

    data class Success(val responseDTO: ResponseDTO):MainUiModel()

    data class Failure(val error:String):MainUiModel()
}
