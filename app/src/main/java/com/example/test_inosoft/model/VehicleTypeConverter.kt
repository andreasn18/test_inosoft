package com.example.test_inosoft.model

import androidx.room.TypeConverter
import org.json.JSONObject

class VehicleTypeConverter {
    @TypeConverter
    fun fromVehicle(vehicle: Vehicle): String {
        return JSONObject().apply {
            put("vehicleYear", vehicle.vehicleYear)
            put("color", vehicle.color)
            put("price", vehicle.price)
        }.toString()
    }

    @TypeConverter
    fun toVehicle(vehicle: String): Vehicle {
        val json = JSONObject(vehicle)
        return Vehicle(json.getString("vehicleYear"), json.getString("color"), json.getString("price"))
    }
}