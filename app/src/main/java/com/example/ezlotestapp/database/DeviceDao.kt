package com.example.ezlotestapp.database

import androidx.room.*
import com.example.ezlotestapp.data.models.Device

@Dao
interface DeviceDao {

    @Delete
    suspend fun deleteDevice(device: Device)

    @Query("SELECT * FROM devices")
    suspend fun getAllDevices(): List<Device>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(devices: List<Device>)

    @Query("UPDATE devices SET platform=:platform WHERE pKDevice = :id")
    suspend fun update(platform: String?, id: Long)
}