package com.dragsville.scantoexcel.ui.screen

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Accounts : Screen("accounts")
    object Settings : Screen("settings")
}