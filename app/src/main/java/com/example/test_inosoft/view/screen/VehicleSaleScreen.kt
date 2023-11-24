package com.example.test_inosoft.view.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.test_inosoft.model.Car
import com.example.test_inosoft.model.Motorcycle
import com.example.test_inosoft.model.VehicleSalesData
import com.example.test_inosoft.model.VehicleStockData
import com.example.test_inosoft.viewmodel.VehicleViewModel

@Composable
fun VehicleSaleScreen(vehicleVM: VehicleViewModel) {
    val list: List<VehicleSalesData> by vehicleVM.vehicleSalesList.observeAsState(initial = listOf())
    vehicleVM.getVehicleSalesList()
    LazyColumn(contentPadding = PaddingValues(16.dp), content = {
        items(list) {
            VehicleItem(vehicleSalesData = it)
            Spacer(modifier = Modifier.height(12.dp))
        }
    })
}

@Composable
fun VehicleItem(vehicleSalesData: VehicleSalesData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Text(text = "Warna: ${vehicleSalesData.vehicle.color}", modifier = Modifier.padding(8.dp))
            Text(
                text = "Tahun: ${vehicleSalesData.vehicle.vehicleYear}",
                modifier = Modifier.padding(8.dp)
            )
            when (vehicleSalesData.vehicle) {
                is Car -> {
                    val car = vehicleSalesData.vehicle
                    Text(
                        text = "Mesin: ${car.engine}",
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Jumlah Penumpang: ${car.totalPassenger}",
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Tipe: ${car.type}",
                        modifier = Modifier.padding(8.dp)
                    )
                }

                is Motorcycle -> {
                    val motor = vehicleSalesData.vehicle
                    Text(
                        text = "Mesin: ${motor.engine}",
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Tipe Suspensi: ${motor.suspensionType}",
                        modifier = Modifier.padding(8.dp)
                    )
                    Text(
                        text = "Tipe Transmisi: ${motor.transmissionType}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            Text(
                text = "Harga: Rp ${vehicleSalesData.vehicle.price}",
                modifier = Modifier.padding(8.dp)
            )
            Text(text = "Total Penjualan Rp ${vehicleSalesData.salesSum}", modifier = Modifier.padding(8.dp))
        }
    }
}