package com.example.ezlotestapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.ezlotestapp.data.models.Device

@Database(entities = [Device::class], version = 1,exportSchema = false)
abstract class DeviceDataBase : RoomDatabase() {
    abstract fun getDevisesDao(): DeviceDao
}