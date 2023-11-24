package com.example.test_inosoft.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.test_inosoft.model.SalesReportData
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleSalesDataTypeConverter
import com.example.test_inosoft.model.VehicleStockData
import com.example.test_inosoft.model.VehicleTypeConverter

@Database(
    entities = [VehicleStockData::class, VehicleSalesData::class],
    version = 3,
    exportSchema = false
)
@TypeConverters(VehicleTypeConverter::class)
abstract class VehicleRoomDatabase : RoomDatabase() {
    abstract fun vehicleDao(): VehicleDao

    companion object {
        @Volatile
        private var INSTANCE: VehicleRoomDatabase? = null

        fun getInstance(context: Context): VehicleRoomDatabase {
            synchronized(this) {
                var instance = INSTANCE

                if (instance == null) {
                    instance = Room.databaseBuilder(
                        context,
                        VehicleRoomDatabase::class.java,
                        "vehicle_database"
                    ).fallbackToDestructiveMigration().build()

                    INSTANCE = instance
                }
                return instance
            }
        }
    }
}