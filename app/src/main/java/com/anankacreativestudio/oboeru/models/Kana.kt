package com.anankacreativestudio.oboeru.models

data class Kana(
    val id: Int,
    val type: KanaType,
    val kana: String,
    val romaji: String,
    val exampleKana: String? = null,
    val exampleRomaji: String? = null,
    val exampleMeaning: String? = null
)

enum class KanaType {
    HIRAGANA,
    KATAKANA
}