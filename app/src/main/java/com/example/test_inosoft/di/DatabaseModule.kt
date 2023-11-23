package com.example.test_inosoft.di

import android.content.Context
import androidx.room.Room
import com.example.test_inosoft.database.VehicleDao
import com.example.test_inosoft.database.VehicleRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
private object DatabaseModule {

    @Provides
    fun provideVehicleDao(appDatabase: VehicleRoomDatabase): VehicleDao {
        return appDatabase.vehicleDao()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext context: Context): VehicleRoomDatabase {
        return Room.databaseBuilder(
            context.applicationContext,
            VehicleRoomDatabase::class.java,
            "appDB"
        ).build()
    }
}