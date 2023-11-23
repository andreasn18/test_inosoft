package com.example.test_inosoft.model

import androidx.room.Entity

@Entity
data class VehicleSalesData(
    val vehicle: Vehicle,
    val salesSum: Int
)
