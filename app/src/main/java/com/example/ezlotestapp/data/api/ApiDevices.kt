package com.example.ezlotestapp.data.api

import com.example.ezlotestapp.data.models.Device
import com.example.ezlotestapp.data.models.DeviseModel
import retrofit2.Response
import retrofit2.http.GET

interface ApiDevices {
    @GET("items.test")
    suspend fun getDevices(): DeviseModel
}