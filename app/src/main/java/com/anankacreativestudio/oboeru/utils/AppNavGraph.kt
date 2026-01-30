package com.anankacreativestudio.oboeru.utils

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.anankacreativestudio.oboeru.ui.screen.HiraganaScreen
import com.anankacreativestudio.oboeru.ui.screen.KanaRecallScreen
import com.anankacreativestudio.oboeru.ui.screen.KatakanaScreen
import com.anankacreativestudio.oboeru.ui.screen.KotobaScreen
import com.anankacreativestudio.oboeru.ui.screen.PracticeScreen
import com.anankacreativestudio.oboeru.ui.screen.QuizScreen
import com.anankacreativestudio.oboeru.ui.screen.ReverseRecallScreen
import com.anankacreativestudio.oboeru.ui.screen.SettingScreen
import com.anankacreativestudio.oboeru.ui.screen.SpeedRoundScreen

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
        composable(Screen.Kotoba.route) {
            KotobaScreen(
                title = "Kotoba",
                onMenuClick = openDrawer
            )
        }
        composable(Screen.Practice.route) {
            PracticeScreen(
                onPracticeClick = { mode ->
                    when (mode.id) {
                        "kana_recall" -> navController.navigate(Screen.KanaRecall.route)
                        "reverse_recall" -> navController.navigate(Screen.ReverseRecall.route)
                        "listening" -> navController.navigate(Screen.Listening.route)
                        "speed_round" -> navController.navigate(Screen.SpeedRound.route)
                    }
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
        composable(Screen.KanaRecall.route) {
            KanaRecallScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.ReverseRecall.route) {
            ReverseRecallScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
        composable(Screen.SpeedRound.route) {
            SpeedRoundScreen(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }
    }
}