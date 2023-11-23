package com.example.test_inosoft.model

import androidx.room.Entity

@Entity
data class VehicleStockData(
    val vehicle: Vehicle,
    val stock: Int
)