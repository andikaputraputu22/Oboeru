package com.anankacreativestudio.oboeru.utils

sealed class Screen(val route: String) {
    data object Hiragana: Screen("hiragana")
    data object Katakana: Screen("katakana")
    data object Kotoba: Screen("kotoba")
    data object Setting: Screen("setting")
    data object Quiz: Screen("quiz")
    data object Practice: Screen("practice")
    data object KanaRecall: Screen("kana_recall")
    data object ReverseRecall: Screen("reverse_recall")
    data object Listening: Screen("listening")
    data object SpeedRound: Screen("speed_round")
}