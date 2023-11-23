package com.example.test_inosoft.model

import androidx.room.Entity

@Entity
data class SalesReportData(
    val vehicleSales: VehicleSalesData,
    val period: String
)
