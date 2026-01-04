package com.anankacreativestudio.oboeru.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anankacreativestudio.oboeru.ui.screen.HiraganaScreen
import com.anankacreativestudio.oboeru.ui.screen.KatakanaScreen
import com.anankacreativestudio.oboeru.ui.screen.PracticeScreen
import com.anankacreativestudio.oboeru.ui.screen.QuizScreen
import com.anankacreativestudio.oboeru.ui.screen.SettingScreen

@Composable
fun AppNavGraph(
    navController: NavHostController,
    openDrawer: () -> Unit
) {
    NavHost(
        navController = navController,
        startDestination = Screen.Hiragana.route
    ) {
        composable(Screen.Hiragana.route) {
            HiraganaScreen(
                title = "Hiragana",
                onMenuClick = openDrawer
            )
        }
        composable(Screen.Katakana.route) {
            KatakanaScreen(
                title = "Katakana",
                onMenuClick = openDrawer
            )
        }
        composable(Screen.Practice.route) {
            PracticeScreen(
                onPracticeClick = { practiceId ->

                },
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Setting.route) {
            SettingScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.Quiz.route) {
            QuizScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}