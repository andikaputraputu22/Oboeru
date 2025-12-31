package com.anankacreativestudio.oboeru.utils

import androidx.navigation.NavController

fun NavController.navigateMain(route: String) {
    navigate(route) {
        popUpTo(0)
        launchSingleTop = true
    }
}

fun NavController.navigateSecondary(route: String) {
    navigate(route)
}