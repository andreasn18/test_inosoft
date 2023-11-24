package com.example.test_inosoft.utils

import com.example.test_inosoft.model.Car
import com.example.test_inosoft.model.Motorcycle
import com.example.test_inosoft.model.SalesReportData
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleStockData
import java.text.DecimalFormat
import java.text.NumberFormat
import java.util.Locale

val dummyVehicleList = listOf(
    Car("2015", "Merah", "100.000.000", "ICE", "6", "SUV"),
    Car("2013", "Hitam", "320.000.000", "ECE", "4", "MPV"),
    Car("2018", "Putih", "517.500.000", "ECE", "6", "Hatchback"),
    Car("2011", "Kuning", "432.000.000", "ICE", "6", "Sedan"),
    Car("2023", "Silver", "750.000.000", "ECE", "6", "Electric"),
    Motorcycle("2015", "Merah", "20.000.000", "Satu Silinder", "Telescopic Fork", "Matic"),
    Motorcycle("2018", "Kuning", "28.000.000", "Satu Silinder", "Shock Telescopic Fork", "Matic"),
    Motorcycle("2020", "Hitam", "50.000.000", "Dua Silinder", "Telescopic Fork", "Manual"),
    Motorcycle("2023", "Putih", "15.000.000", "Satu Silinder", "Telescopic Fork", "Matic"),
    Motorcycle("2021", "Hijau", "30.000.000", "Satu Silinder", "Telescopic Fork", "Matic"),
)

val dummyVehicleStocksList = listOf(
    VehicleStockData(dummyVehicleList[0], 8),
    VehicleStockData(dummyVehicleList[1], 5),
    VehicleStockData(dummyVehicleList[2], 20),
    VehicleStockData(dummyVehicleList[3], 4),
    VehicleStockData(dummyVehicleList[4], 7),
    VehicleStockData(dummyVehicleList[5], 16),
    VehicleStockData(dummyVehicleList[6], 8),
    VehicleStockData(dummyVehicleList[7], 3),
    VehicleStockData(dummyVehicleList[8], 2),
    VehicleStockData(dummyVehicleList[9], 9),
)

val dummyVehicleSalesList = listOf(
    VehicleSalesData(dummyVehicleList[0], "500.000.000"),
    VehicleSalesData(dummyVehicleList[1], "740.000.000"),
    VehicleSalesData(dummyVehicleList[2], "430.000.000"),
    VehicleSalesData(dummyVehicleList[3], "5.000.000.000"),
    VehicleSalesData(dummyVehicleList[4], "500.000.000"),
    VehicleSalesData(dummyVehicleList[5], "50.000.000"),
    VehicleSalesData(dummyVehicleList[6], "100.000.000"),
    VehicleSalesData(dummyVehicleList[7], "780.000.000"),
    VehicleSalesData(dummyVehicleList[8], "460.000.000"),
    VehicleSalesData(dummyVehicleList[9], "980.000.000"),
)

val dummySalesReportList = listOf(
    SalesReportData(listOf(dummyVehicleSalesList[0], dummyVehicleSalesList[1]), "Agustus"),
    SalesReportData(listOf(dummyVehicleSalesList[2]), "Juli"),
    SalesReportData(listOf(dummyVehicleSalesList[3]), "Juni"),
    SalesReportData(listOf(dummyVehicleSalesList[4]), "September"),
    SalesReportData(listOf(dummyVehicleSalesList[5]), "Oktober"),
    SalesReportData(
        listOf(
            dummyVehicleSalesList[6],
            dummyVehicleSalesList[7],
            dummyVehicleSalesList[8],
            dummyVehicleSalesList[9]
        ), "November"
    ),
    SalesReportData(listOf(dummyVehicleSalesList[9]), "Desember"),
)

fun Int.toRupiah(): String {
    val localeID = Locale("in", "ID")
    val formatter = DecimalFormat("###,###,###")
    val formatRupiah = NumberFormat.getCurrencyInstance(localeID)
    val finalRupiah = formatter.format(this.toDouble()).replace(",", ".")
    return "Rp " + finalRupiah
}