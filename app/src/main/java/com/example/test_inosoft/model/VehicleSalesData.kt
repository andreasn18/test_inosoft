package com.example.test_inosoft.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "VehicleSalesData")
data class VehicleSalesData(
    val vehicle: Vehicle,
    val salesSum: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
)
