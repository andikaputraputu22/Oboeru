package com.anankacreativestudio.oboeru.repository

import com.anankacreativestudio.oboeru.models.Kana
import com.anankacreativestudio.oboeru.models.KanaType
import javax.inject.Inject

class KanaRepository @Inject constructor() {

    val hiraganaList = listOf(
        // a
        Kana(1, KanaType.HIRAGANA, "あ", "a"),
        Kana(2, KanaType.HIRAGANA, "い", "i"),
        Kana(3, KanaType.HIRAGANA, "う", "u"),
        Kana(4, KanaType.HIRAGANA, "え", "e"),
        Kana(5, KanaType.HIRAGANA, "お", "o"),

        // ka
        Kana(6, KanaType.HIRAGANA, "か", "ka"),
        Kana(7, KanaType.HIRAGANA, "き", "ki"),
        Kana(8, KanaType.HIRAGANA, "く", "ku"),
        Kana(9, KanaType.HIRAGANA, "け", "ke"),
        Kana(10, KanaType.HIRAGANA, "こ", "ko"),

        // sa
        Kana(11, KanaType.HIRAGANA, "さ", "sa"),
        Kana(12, KanaType.HIRAGANA, "し", "shi"),
        Kana(13, KanaType.HIRAGANA, "す", "su"),
        Kana(14, KanaType.HIRAGANA, "せ", "se"),
        Kana(15, KanaType.HIRAGANA, "そ", "so"),

        // ta
        Kana(16, KanaType.HIRAGANA, "た", "ta"),
        Kana(17, KanaType.HIRAGANA, "ち", "chi"),
        Kana(18, KanaType.HIRAGANA, "つ", "tsu"),
        Kana(19, KanaType.HIRAGANA, "て", "te"),
        Kana(20, KanaType.HIRAGANA, "と", "to"),

        // na
        Kana(21, KanaType.HIRAGANA, "な", "na"),
        Kana(22, KanaType.HIRAGANA, "に", "ni"),
        Kana(23, KanaType.HIRAGANA, "ぬ", "nu"),
        Kana(24, KanaType.HIRAGANA, "ね", "ne"),
        Kana(25, KanaType.HIRAGANA, "の", "no"),

        // ha
        Kana(26, KanaType.HIRAGANA, "は", "ha"),
        Kana(27, KanaType.HIRAGANA, "ひ", "hi"),
        Kana(28, KanaType.HIRAGANA, "ふ", "fu"),
        Kana(29, KanaType.HIRAGANA, "へ", "he"),
        Kana(30, KanaType.HIRAGANA, "ほ", "ho"),

        // ma
        Kana(31, KanaType.HIRAGANA, "ま", "ma"),
        Kana(32, KanaType.HIRAGANA, "み", "mi"),
        Kana(33, KanaType.HIRAGANA, "む", "mu"),
        Kana(34, KanaType.HIRAGANA, "め", "me"),
        Kana(35, KanaType.HIRAGANA, "も", "mo"),

        // ya
        Kana(36, KanaType.HIRAGANA, "や", "ya"),
        Kana(37, KanaType.HIRAGANA, "ゆ", "yu"),
        Kana(38, KanaType.HIRAGANA, "よ", "yo"),

        // ra
        Kana(39, KanaType.HIRAGANA, "ら", "ra"),
        Kana(40, KanaType.HIRAGANA, "り", "ri"),
        Kana(41, KanaType.HIRAGANA, "る", "ru"),
        Kana(42, KanaType.HIRAGANA, "れ", "re"),
        Kana(43, KanaType.HIRAGANA, "ろ", "ro"),

        // wa + n
        Kana(44, KanaType.HIRAGANA, "わ", "wa"),
        Kana(45, KanaType.HIRAGANA, "を", "wo"),
        Kana(46, KanaType.HIRAGANA, "ん", "n")
    )

    val katakanaList = listOf(
        // a
        Kana(101, KanaType.KATAKANA, "ア", "a"),
        Kana(102, KanaType.KATAKANA, "イ", "i"),
        Kana(103, KanaType.KATAKANA, "ウ", "u"),
        Kana(104, KanaType.KATAKANA, "エ", "e"),
        Kana(105, KanaType.KATAKANA, "オ", "o"),

        // ka
        Kana(106, KanaType.KATAKANA, "カ", "ka"),
        Kana(107, KanaType.KATAKANA, "キ", "ki"),
        Kana(108, KanaType.KATAKANA, "ク", "ku"),
        Kana(109, KanaType.KATAKANA, "ケ", "ke"),
        Kana(110, KanaType.KATAKANA, "コ", "ko"),

        // sa
        Kana(111, KanaType.KATAKANA, "サ", "sa"),
        Kana(112, KanaType.KATAKANA, "シ", "shi"),
        Kana(113, KanaType.KATAKANA, "ス", "su"),
        Kana(114, KanaType.KATAKANA, "セ", "se"),
        Kana(115, KanaType.KATAKANA, "ソ", "so"),

        // ta
        Kana(116, KanaType.KATAKANA, "タ", "ta"),
        Kana(117, KanaType.KATAKANA, "チ", "chi"),
        Kana(118, KanaType.KATAKANA, "ツ", "tsu"),
        Kana(119, KanaType.KATAKANA, "テ", "te"),
        Kana(120, KanaType.KATAKANA, "ト", "to"),

        // na
        Kana(121, KanaType.KATAKANA, "ナ", "na"),
        Kana(122, KanaType.KATAKANA, "ニ", "ni"),
        Kana(123, KanaType.KATAKANA, "ヌ", "nu"),
        Kana(124, KanaType.KATAKANA, "ネ", "ne"),
        Kana(125, KanaType.KATAKANA, "ノ", "no"),

        // ha
        Kana(126, KanaType.KATAKANA, "ハ", "ha"),
        Kana(127, KanaType.KATAKANA, "ヒ", "hi"),
        Kana(128, KanaType.KATAKANA, "フ", "fu"),
        Kana(129, KanaType.KATAKANA, "ヘ", "he"),
        Kana(130, KanaType.KATAKANA, "ホ", "ho"),

        // ma
        Kana(131, KanaType.KATAKANA, "マ", "ma"),
        Kana(132, KanaType.KATAKANA, "ミ", "mi"),
        Kana(133, KanaType.KATAKANA, "ム", "mu"),
        Kana(134, KanaType.KATAKANA, "メ", "me"),
        Kana(135, KanaType.KATAKANA, "モ", "mo"),

        // ya
        Kana(136, KanaType.KATAKANA, "ヤ", "ya"),
        Kana(137, KanaType.KATAKANA, "ユ", "yu"),
        Kana(138, KanaType.KATAKANA, "ヨ", "yo"),

        // ra
        Kana(139, KanaType.KATAKANA, "ラ", "ra"),
        Kana(140, KanaType.KATAKANA, "リ", "ri"),
        Kana(141, KanaType.KATAKANA, "ル", "ru"),
        Kana(142, KanaType.KATAKANA, "レ", "re"),
        Kana(143, KanaType.KATAKANA, "ロ", "ro"),

        // wa + n
        Kana(144, KanaType.KATAKANA, "ワ", "wa"),
        Kana(145, KanaType.KATAKANA, "ヲ", "wo"),
        Kana(146, KanaType.KATAKANA, "ン", "n")
    )
}