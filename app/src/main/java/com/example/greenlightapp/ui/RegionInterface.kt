package com.example.greenlightapp.ui

import com.example.greenlightapp.response.ResponseDTO
import com.example.greenlightapp.response.ResponseData

interface RegionInterface {

    fun clickItem(region:String,responseData: ResponseData)
}