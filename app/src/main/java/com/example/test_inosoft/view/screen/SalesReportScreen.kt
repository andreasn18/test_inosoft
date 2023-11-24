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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.test_inosoft.model.Car
import com.example.test_inosoft.model.Motorcycle
import com.example.test_inosoft.model.SalesReportData
import com.example.test_inosoft.utils.dummySalesReportList
import com.example.test_inosoft.utils.toRupiah

@Composable
fun SalesReportScreen() {
    LazyColumn(contentPadding = PaddingValues(16.dp), content = {
        items(dummySalesReportList) {
            VehicleItem(salesReportData = it)
            Spacer(modifier = Modifier.height(12.dp))
        }
    })
}

@Composable
fun VehicleItem(salesReportData: SalesReportData) {
    Card(
        modifier = Modifier.fillMaxWidth(),
        shape = RoundedCornerShape(12.dp)
    ) {
        Column {
            Text(text = "Periode: ${salesReportData.period}", modifier = Modifier.padding(8.dp))
            Spacer(modifier = Modifier.height(4.dp))
            salesReportData.vehicleSales.forEach { vehicleSales ->
                Column(Modifier.padding(8.dp)) {
                    Text(
                        text = "Tahun: ${vehicleSales.vehicle.vehicleYear}",
                        modifier = Modifier.padding(8.dp)
                    )
                    when (vehicleSales.vehicle) {
                        is Car -> {
                            val car = vehicleSales.vehicle
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
                            val motor = vehicleSales.vehicle
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
                        text = "Sub Total: Rp ${vehicleSales.salesSum}",
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
            val sumSales =
                salesReportData.vehicleSales.sumOf { it.salesSum.replace(".", "").toInt() }
            Text(
                text = "Total Penjualan ${sumSales.toRupiah()}",
                modifier = Modifier.padding(8.dp)
            )

        }
    }
}
