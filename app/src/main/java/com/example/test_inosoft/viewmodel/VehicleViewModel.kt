package com.example.test_inosoft.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.test_inosoft.model.SalesReportData
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleStockData
import com.example.test_inosoft.repository.VehicleRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VehicleViewModel @Inject constructor(private val vehicleRepository: VehicleRepository) :
    ViewModel() {

    val vehicleStockList: LiveData<List<VehicleStockData>> = vehicleRepository.vehicleStockList
    val vehicleSalesList: LiveData<List<VehicleSalesData>> = vehicleRepository.vehicleSalesList
    val salesReportList: LiveData<List<SalesReportData>> = vehicleRepository.salesReportList

    fun addVehicleStock(vararg vehicleStock: VehicleStockData) {
        vehicleRepository.addVehicleStock(*vehicleStock)
    }

    fun addVehicleSales(vararg vehicleSales: VehicleSalesData) {
        vehicleRepository.addVehicleSales(*vehicleSales)
    }

//    fun addSalesReport(salesReport: SalesReportData) {
//        vehicleRepository.addSalesReport(salesReport)
//    }

    fun getVehicleStockList() {
        vehicleRepository.getVehicleStockList()
    }

    fun getVehicleSalesList() {
        vehicleRepository.getVehicleSalesList()
    }

//    fun getSalesReportList() {
//        vehicleRepository.getSalesReportList()
//    }
}