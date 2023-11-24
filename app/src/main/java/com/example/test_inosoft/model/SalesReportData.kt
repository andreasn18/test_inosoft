package com.example.test_inosoft.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters

@Entity(tableName = "SalesReportData")
data class SalesReportData(
    val vehicleSales: List<VehicleSalesData>,
    val period: String,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
)
