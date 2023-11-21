package com.example.test_inosoft

sealed class BottomNavItem(val title: String, val route: String) {

    object Stock: BottomNavItem("Stok", "stock")
    object VehicleSale: BottomNavItem("Penjualan", "vehicle_sale")
    object SaleReport: BottomNavItem("Laporan", "sale_report")
}
