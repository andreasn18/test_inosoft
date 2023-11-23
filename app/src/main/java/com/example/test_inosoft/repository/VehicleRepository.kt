package com.example.test_inosoft.repository

import androidx.lifecycle.MutableLiveData
import com.example.test_inosoft.database.VehicleDao
import com.example.test_inosoft.model.SalesReportData
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleStockData
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class VehicleRepository(private val vehicleDao: VehicleDao) {
    val vehicleStockList = MutableLiveData<List<VehicleStockData>>()
    val vehicleSalesList = MutableLiveData<List<VehicleSalesData>>()
    val salesReportList = MutableLiveData<List<SalesReportData>>()
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    fun addVehicleStock(vehicleStock: VehicleStockData) {
        coroutineScope.launch(Dispatchers.IO) {
            vehicleDao.addVehicleStock(vehicleStock)
        }
    }

    fun addVehicleSales(vehicleSales: VehicleSalesData) {
        coroutineScope.launch(Dispatchers.IO) {
            vehicleDao.addVehicleSales(vehicleSales)
        }
    }

    fun addSalesReport(salesReport: SalesReportData) {
        coroutineScope.launch(Dispatchers.IO) {
            vehicleDao.addSalesReport(salesReport)
        }
    }

    fun getVehicleStockList() {
        coroutineScope.launch(Dispatchers.IO) {
            vehicleStockList.postValue(vehicleDao.getAllStockData())
        }
    }

    fun getVehicleSalesList() {
        coroutineScope.launch(Dispatchers.IO) {
            vehicleSalesList.postValue(vehicleDao.getAllSalesData())
        }
    }

    fun getSalesReportList() {
        coroutineScope.launch(Dispatchers.IO) {
            salesReportList.postValue(vehicleDao.getAllReportData())
        }
    }
}