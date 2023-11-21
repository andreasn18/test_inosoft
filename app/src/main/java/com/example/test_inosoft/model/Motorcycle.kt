package com.example.test_inosoft.model

class Motorcycle(
    pVehicleYear: String,
    pColor: String,
    pPrice: String,
    val engine: String = "",
    val suspensionType: String = "",
    val transmissionType: String = ""
) : Vehicle(pVehicleYear, pColor, pPrice)