package com.example.ezlotestapp.ui.view

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ezlotestapp.data.models.Device
import com.example.ezlotestapp.data.repository.DevicesRepository
import com.example.ezlotestapp.utils.Constants.VERA_EDGE_BIG
import com.example.ezlotestapp.utils.Constants.VERA_PLUS_BIG
import com.example.ezlotestapp.utils.Constants.VERA_SECURE_BIG
import com.example.ezlotestapp.utils.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import androidx.compose.runtime.setValue

@HiltViewModel
class SharedViewModel @Inject constructor(
    private val repository: DevicesRepository
) : ViewModel() {
    val devices = mutableStateOf<MutableList<Device>>(mutableListOf())
    var isLoading = mutableStateOf(false)
    var isError = mutableStateOf(false)
    var device by mutableStateOf<Device?>(null)
        private set

    init {
        getDevices()
    }

    fun addDevice(newDevice: Device) {
        device = newDevice
    }

    fun getDevices() {
        viewModelScope.launch {
            isLoading.value = true
            when (val result = repository.getDevices()) {
                is Resource.Loading -> loading()
                is Resource.Success -> success(result = result.data)
                is Resource.Error -> error()
            }
        }
    }

    fun deleteDevice(deleteDevice: Device) {
        viewModelScope.launch {
            devices.value.map {
                devices.value = devices.value.filter { it != deleteDevice } as MutableList<Device>
            }
            repository.deleteDeviseFromDB(deleteDevice)
        }
    }

    fun editDevice(editDevice: Device) {
        viewModelScope.launch {
            devices.value.find {
                it.pKDevice == editDevice.pKDevice
            }?.platform = editDevice.platform
            repository.upDataDeviseInDB(
                platform = editDevice.platform,
                id = editDevice.pKDevice
            )
        }
    }

    private fun loading() {
        isLoading.value = true
        isError.value = false
    }

    private suspend fun error() {
        isLoading.value = false
        isError.value = true
        devices.value = repository.getDevisesFromDB() as MutableList<Device>
    }

    private suspend fun success(result: List<Device>?) {
        if (result != null) {
            result.map {
                it.urlImg = when (it.platform) {
                    TypeDevise.SERCOMM_G450 -> VERA_PLUS_BIG
                    TypeDevise.SERCOMM_G550 -> VERA_SECURE_BIG
                    else -> VERA_EDGE_BIG
                }
            }
            isLoading.value = false
            isError.value = false
            devices.value = result as MutableList
            val devisesDB = repository.getDevisesFromDB()
            devisesDB.map { itemDB ->
                devices.value.find {
                    it.pKDevice == itemDB.pKDevice
                }?.platform = itemDB.platform
            }
        }
        repository.addDevisesToDB(devices = devices.value)
    }

    object TypeDevise {
        const val SERCOMM_G450 = "Sercomm G450"
        const val SERCOMM_G550 = "Sercomm G550"
    }
}

