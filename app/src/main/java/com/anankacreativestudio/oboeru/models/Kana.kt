package com.anankacreativestudio.oboeru.models

data class Kana(
    val id: Int,
    val type: KanaType,
    val kana: String,
    val romaji: String
)

enum class KanaType {
    HIRAGANA,
    KATAKANA
}