package com.example.test_inosoft.di

import com.example.test_inosoft.database.VehicleDao
import com.example.test_inosoft.repository.VehicleRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideVehicleRepository(vehicleDao: VehicleDao): VehicleRepository {
        return VehicleRepository(vehicleDao)
    }
}