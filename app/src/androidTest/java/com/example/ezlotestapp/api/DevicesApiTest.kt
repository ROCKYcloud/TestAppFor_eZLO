package com.example.ezlotestapp.api

import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ezlotestapp.data.api.ApiDevices
import com.example.ezlotestapp.utils.Constants
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.Test
import org.junit.runner.RunWith
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@RunWith(AndroidJUnit4ClassRunner::class)
class DevicesApiTest : TestCase() {

    @Test
    fun getDevicesFromApi() {
        val api = provideApi()
        val test = runBlocking {
            api.getDevices()
        }
        assertEquals(test.Devices.isNotEmpty(), true)
    }

    private fun provideApi(): ApiDevices = Retrofit.Builder()
        .baseUrl(Constants.BASE_URL)
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(ApiDevices::class.java)
}