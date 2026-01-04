package com.anankacreativestudio.oboeru.utils

sealed class Screen(val route: String) {
    data object Hiragana: Screen("hiragana")
    data object Katakana: Screen("katakana")
    data object Setting: Screen("setting")
    data object Quiz: Screen("quiz")
    data object Practice: Screen("practice")
}