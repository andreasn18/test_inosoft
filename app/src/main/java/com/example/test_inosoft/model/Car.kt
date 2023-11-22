package com.example.test_inosoft.model

data class Car(
    val pVehicleYear: String,
    val pColor: String,
    val pPrice: String,
    val engine: String = "",
    val totalPassenger: String = "",
    val type: String = ""
) : Vehicle(pVehicleYear, pColor, pPrice)
