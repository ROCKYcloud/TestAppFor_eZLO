package com.example.ezlotestapp.data.repository

import com.example.ezlotestapp.data.models.Device
import com.example.ezlotestapp.data.api.ApiDevices
import com.example.ezlotestapp.database.DeviceDao
import com.example.ezlotestapp.utils.Resource
import javax.inject.Inject

class DevicesRepository @Inject constructor(
    private val api: ApiDevices,
    private val deviceDao: DeviceDao,
) {
    suspend fun getDevices(): Resource<List<Device>> {
        return try {
            val resp = api.getDevices()
                   Resource.Success(resp.Devices)
        } catch (e: Exception) {
            Resource.Error("$e")
        }
    }

    suspend fun addDevisesToDB(devices: List<Device>) {
        deviceDao.insert(devices)
    }
    suspend fun getDevisesFromDB() : List<Device> {
      return  deviceDao.getAllDevices()
    }
    suspend fun deleteDeviseFromDB(device: Device){
        deviceDao.deleteDevice(device)
    }
    suspend fun upDataDeviseInDB(platform:String,id:Long){
        deviceDao.update(platform= platform, id = id)
    }
}