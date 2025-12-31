package com.anankacreativestudio.oboeru

import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.anankacreativestudio.oboeru.ui.component.DrawerLayout
import com.anankacreativestudio.oboeru.utils.AppNavGraph
import com.anankacreativestudio.oboeru.utils.Screen
import com.anankacreativestudio.oboeru.utils.navigateMain
import com.anankacreativestudio.oboeru.utils.navigateSecondary
import com.anankacreativestudio.oboeru.viewmodel.MainViewModel
import kotlinx.coroutines.launch

@Composable
fun OboeruApp(
    openQuizFromNotification: Boolean
) {
    val mainViewModel: MainViewModel = hiltViewModel()
    val scope = rememberCoroutineScope()
    val navController = rememberNavController()
    val navBackStackEntry = navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry.value?.destination?.route
    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val gesturesDrawableEnabled = currentRoute == Screen.Hiragana.route
            || currentRoute == Screen.Katakana.route

    LaunchedEffect(openQuizFromNotification) {
        if (openQuizFromNotification) {
            navController.navigate(Screen.Quiz.route) {
                launchSingleTop = true
            }
        }
    }

    ModalNavigationDrawer(
        drawerState = drawerState,
        gesturesEnabled = gesturesDrawableEnabled,
        drawerContent = {
            DrawerLayout(
                currentRoute = currentRoute,
                onItemClick = { route ->
                    when (route) {
                        Screen.Hiragana.route,
                        Screen.Katakana.route -> {
                            navController.navigateMain(route)
                        }
                        else -> {
                            navController.navigateSecondary(route)
                        }
                    }

                    scope.launch { drawerState.close() }
                }
            )
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