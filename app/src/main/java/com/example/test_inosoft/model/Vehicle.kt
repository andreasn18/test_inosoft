package com.example.test_inosoft.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
open class Vehicle(
    open val vehicleYear: String,
    open val color: String,
    open val price: String
):Parcelable