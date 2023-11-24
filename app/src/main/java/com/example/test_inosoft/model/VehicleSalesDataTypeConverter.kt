package com.example.test_inosoft.model

import androidx.room.TypeConverter
import org.json.JSONObject

class VehicleSalesDataTypeConverter {

    @TypeConverter
    fun fromVehicleSalesData(vehicleSalesData: VehicleSalesData): String {
        return JSONObject().apply {
            put("id", vehicleSalesData.id)
            put("salesSum", vehicleSalesData.salesSum)
            put("vehicle", vehicleSalesData.vehicle)
        }.toString()
    }

    fun toVehicleSalesData(vehicleSalesData: String): VehicleSalesData {
        val json = JSONObject(vehicleSalesData)
        return VehicleSalesData(
            json.get("vehicle") as Vehicle,
            json.getString("salesSum"),
            json.getInt("id")
        )
    }
}