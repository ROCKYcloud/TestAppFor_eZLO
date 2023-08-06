package com.example.ezlotestapp.db

import android.content.Context
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import com.example.ezlotestapp.data.models.Device
import com.example.ezlotestapp.database.DeviceDao
import com.example.ezlotestapp.database.DeviceDataBase
import junit.framework.TestCase
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4ClassRunner::class)
class DevisesDataBaseTest : TestCase() {
    private lateinit var deviceDao: DeviceDao
    private lateinit var db: DeviceDataBase

    @Test
    fun insertDevises() = runBlocking {
        deviceDao.insert(getDevises())
        val devises = deviceDao.getAllDevices()
        Assert.assertEquals(devises.isNotEmpty(), true)
    }

    @Test
    fun deleteDevise() = runBlocking {
        deviceDao.insert(getDevises())
        deviceDao.deleteDevice(getDevise())
        val devices = deviceDao.getAllDevices()
        Assert.assertEquals(!devices.contains(getDevise()), true)
    }

    @Test
    fun editDevise() = runBlocking{
        deviceDao.insert(getDevises())
        deviceDao.update(
            platform = upDatedDevice().platform,
            id = upDatedDevice().pKDevice)

        val devices = deviceDao.getAllDevices()
        Assert.assertEquals(devices.contains(upDatedDevice()), true)
    }

    @Before
    fun createDb() {
        val context = ApplicationProvider.getApplicationContext<Context>()
        db = Room.inMemoryDatabaseBuilder(
            context, DeviceDataBase::class.java
        ).build()
        deviceDao = db.getDevisesDao()
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }

    private fun getDevises() = listOf(
        Device(
            pKDevice = 45013855,
            macAddress = "e0:60:66:02:e2:1b",
            platform = "Sercomm NA301",
            pKDeviceType = 1,
            pKDeviceSubType = 2,
            firmware = "1.7.455",
            serverDevice = "vera-us-oem-device12.mios.com",
            serverEvent = "vera-us-oem-event12.mios.com",
            serverAccount = "vera-us-oem-account12.mios.com",
            internalIP = "192.168.6.213",
            lastAliveReported = "2018-02-20 04:17:43",
        )
    )

    private fun getDevise() = Device(
        pKDevice = 45013855,
        macAddress = "e0:60:66:02:e2:1b",
        platform = "Sercomm NA301",
        pKDeviceType = 1,
        pKDeviceSubType = 2,
        firmware = "1.7.455",
        serverDevice = "vera-us-oem-device12.mios.com",
        serverEvent = "vera-us-oem-event12.mios.com",
        serverAccount = "vera-us-oem-account12.mios.com",
        internalIP = "192.168.6.213",
        lastAliveReported = "2018-02-20 04:17:43",
    )

   private fun upDatedDevice() = Device(
    pKDevice = 45013855,
    macAddress = "e0:60:66:02:e2:1b",
    platform = "Sercomm Updated",
    pKDeviceType = 1,
    pKDeviceSubType = 2,
    firmware = "1.7.455",
    serverDevice = "vera-us-oem-device12.mios.com",
    serverEvent = "vera-us-oem-event12.mios.com",
    serverAccount = "vera-us-oem-account12.mios.com",
    internalIP = "192.168.6.213",
    lastAliveReported = "2018-02-20 04:17:43",
    )
}