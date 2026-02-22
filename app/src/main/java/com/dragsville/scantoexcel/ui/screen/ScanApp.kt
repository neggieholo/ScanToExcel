package com.dragsville.scantoexcel.ui.screen

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dragsville.scantoexcel.ui.ScanViewModelProvider
import com.dragsville.scantoexcel.ui.viewmodel.ScanViewModel

@Composable
fun ScanApp(
    scanViewModel: ScanViewModel = viewModel(
        factory = ScanViewModelProvider.Factory
    )
) {
    val navController = rememberNavController()

    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    // Trigger scan
                    scanViewModel.addFakeScan()
                }
            ) {
                Icon(Icons.Default.Add, contentDescription = "Scan Document")
            }
        }
    ) { padding ->

        NavHost(
            navController = navController,
            startDestination = Screen.Home.route,
            modifier = Modifier.padding(padding)
        ) {
            composable(Screen.Home.route) {
                HomeScreen(scanViewModel)
            }
            composable(Screen.Accounts.route) {
                AccountsScreen()
            }
            composable(Screen.Settings.route) {
                SettingsScreen()
            }
        }
    }
}