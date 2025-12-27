package com.anankacreativestudio.oboeru

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.anankacreativestudio.oboeru.ui.component.DrawerLayout
import com.anankacreativestudio.oboeru.utils.AppNavGraph
import com.anankacreativestudio.oboeru.utils.Screen
import kotlinx.coroutines.launch

@Composable
fun OboeruApp() {
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val gesturesDrawerEnabled = currentRoute == Screen.Hiragana.route
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)

    ModalNavigationDrawer(
        drawerState = drawerState,
        drawerContent = {
            DrawerLayout()
        }
    ) {
        AppNavGraph(
            navController = navController,
            openDrawer = {
                scope.launch { drawerState.open() }
            }
        )
    }
}