package com.example.test_inosoft.model

data class Motorcycle(
    val pVehicleYear: String,
    val pColor: String,
    val pPrice: String,
    val engine: String = "",
    val suspensionType: String = "",
    val transmissionType: String = ""
) : Vehicle(pVehicleYear, pColor, pPrice)