package com.example.test_inosoft

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.BadgedBox
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.test_inosoft.view.screen.SalesReportScreen
import com.example.test_inosoft.view.screen.VehicleSaleScreen
import com.example.test_inosoft.view.screen.VehicleStockScreen
import com.example.test_inosoft.view.theme.Test_inosoftTheme
import com.example.test_inosoft.viewmodel.VehicleViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
@OptIn(ExperimentalMaterial3Api::class)
class MainActivity : ComponentActivity() {

    private val vehicleVM: VehicleViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()
            Test_inosoftTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(bottomBar = { bottomNav(navController) }) {
                        Box(modifier = Modifier.padding(it)) {
                            navGraph(navController = navController)
                        }
                    }
                }
            }
        }
    }

    @Composable
    fun bottomNav(navHost: NavHostController) {
        var selectedIndex by rememberSaveable {
            mutableIntStateOf(0)
        }
        val items = listOf(
            BottomNavItem.Stock,
            BottomNavItem.VehicleSale,
            BottomNavItem.SaleReport
        )

        NavigationBar {
            items.forEachIndexed { index, bottomNavItem ->
                NavigationBarItem(
                    selected = selectedIndex == index,
                    onClick = {
                        selectedIndex = index
                        navHost.navigate(bottomNavItem.route)
                    },
                    icon = {
                        BadgedBox(badge = {}) {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = bottomNavItem.title
                            )
                        }

                    },
                    label = { Text(text = bottomNavItem.title) })
            }
        }
    }

    @Composable
    fun navGraph(navController: NavHostController) {
        NavHost(navController = navController, startDestination = BottomNavItem.Stock.route) {
            composable(BottomNavItem.Stock.route) {
                VehicleStockScreen()
            }
            composable(BottomNavItem.VehicleSale.route) {
                VehicleSaleScreen()
            }
            composable(BottomNavItem.SaleReport.route) {
                SalesReportScreen()
            }
        }
    }
}