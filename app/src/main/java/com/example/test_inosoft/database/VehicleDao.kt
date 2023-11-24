package com.example.test_inosoft.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.test_inosoft.model.SalesReportData
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleStockData

@Dao
interface VehicleDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVehicleStock(vararg vehicleStock: VehicleStockData)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun addVehicleSales(vararg vehicleSale: VehicleSalesData)

//    @Insert(onConflict = OnConflictStrategy.IGNORE)
//    suspend fun addSalesReport(salesReport: SalesReportData)

    @Query("SELECT * FROM VehicleStockData")
    suspend fun getAllStockData(): List<VehicleStockData>

    @Query("SELECT * FROM VehicleSalesData")
    suspend fun getAllSalesData(): List<VehicleSalesData>

//    @Query("SELECT * FROM SalesReportData")
//    suspend fun getAllReportData(): List<SalesReportData>
}