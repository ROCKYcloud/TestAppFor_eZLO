package com.example.ezlotestapp.data.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(
    tableName = "devices"
)
data class Device(
    @SerializedName("PK_Device")
    @PrimaryKey
    var pKDevice: Long,
    @SerializedName("MacAddress")
    var macAddress: String? = null,
    @SerializedName("PK_DeviceType")
    var pKDeviceType: Int? = null,
    @SerializedName("PK_DeviceSubType")
    var pKDeviceSubType: Int? = null,
    @SerializedName("Firmware")
    var firmware: String? = null,
    @SerializedName("Server_Device")
    var serverDevice: String? = null,
    @SerializedName("Server_Event")
    var serverEvent: String? = null,
    @SerializedName("Server_Account")
    var serverAccount: String? = null,
    @SerializedName("InternalIP")
    var internalIP: String? = null,
    @SerializedName("LastAliveReported")
    var lastAliveReported: String? = null,
    @SerializedName("Platform")
    var platform: String,
    var urlImg: String? = null
)