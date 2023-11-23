package com.example.test_inosoft.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleStockData

@Database(
    entities = [(VehicleStockData::class), (VehicleSalesData::class)],
    version = 1,
    exportSchema = false
)
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