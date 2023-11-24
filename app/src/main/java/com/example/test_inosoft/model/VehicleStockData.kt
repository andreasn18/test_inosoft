package com.example.test_inosoft.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Parcelize
@Entity(tableName = "VehicleStockData")
data class VehicleStockData(
    val vehicle: Vehicle,
    val stock: Int,
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0
):Parcelable