package com.example.test_inosoft.model

class Car(
    pVehicleYear: String,
    pColor: String,
    pPrice: String,
    val engine: String = "",
    val totalPassenger: String = "",
    val type: String = ""
) : Vehicle(pVehicleYear, pColor, pPrice)
