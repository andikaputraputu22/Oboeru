package com.anankacreativestudio.oboeru.repository

import com.anankacreativestudio.oboeru.models.Kana
import com.anankacreativestudio.oboeru.models.KanaType
import javax.inject.Inject

class KanaRepository @Inject constructor() {

    val hiraganaList = listOf(
        // a
        Kana(1, KanaType.HIRAGANA, "あ", "a", "あさ", "asa", "pagi"),
        Kana(2, KanaType.HIRAGANA, "い", "i", "いぬ", "inu", "anjing"),
        Kana(3, KanaType.HIRAGANA, "う", "u", "うみ", "umi", "laut"),
        Kana(4, KanaType.HIRAGANA, "え", "e", "えき", "eki", "stasiun"),
        Kana(5, KanaType.HIRAGANA, "お", "o", "おちゃ", "ocha", "teh"),

        // ka
        Kana(6, KanaType.HIRAGANA, "か", "ka", "かさ", "kasa", "payung"),
        Kana(7, KanaType.HIRAGANA, "き", "ki", "き", "ki", "pohon"),
        Kana(8, KanaType.HIRAGANA, "く", "ku", "くつ", "kutsu", "sepatu"),
        Kana(9, KanaType.HIRAGANA, "け", "ke", "けさ", "kesa", "pagi ini"),
        Kana(10, KanaType.HIRAGANA, "こ", "ko", "こえ", "koe", "suara"),

        // sa
        Kana(11, KanaType.HIRAGANA, "さ", "sa", "さかな", "sakana", "ikan"),
        Kana(12, KanaType.HIRAGANA, "し", "shi", "しろ", "shiro", "putih"),
        Kana(13, KanaType.HIRAGANA, "す", "su", "すし", "sushi", "sushi"),
        Kana(14, KanaType.HIRAGANA, "せ", "se", "せかい", "sekai", "dunia"),
        Kana(15, KanaType.HIRAGANA, "そ", "so", "そら", "sora", "langit"),

        // ta
        Kana(16, KanaType.HIRAGANA, "た", "ta", "たまご", "tamago", "telur"),
        Kana(17, KanaType.HIRAGANA, "ち", "chi", "ちず", "chizu", "peta"),
        Kana(18, KanaType.HIRAGANA, "つ", "tsu", "つき", "tsuki", "bulan"),
        Kana(19, KanaType.HIRAGANA, "て", "te", "て", "te", "tangan"),
        Kana(20, KanaType.HIRAGANA, "と", "to", "とり", "tori", "burung"),

        // na
        Kana(21, KanaType.HIRAGANA, "な", "na", "なつ", "natsu", "musim panas"),
        Kana(22, KanaType.HIRAGANA, "に", "ni", "にく", "niku", "daging"),
        Kana(23, KanaType.HIRAGANA, "ぬ", "nu", "ぬの", "nuno", "kain"),
        Kana(24, KanaType.HIRAGANA, "ね", "ne", "ねこ", "neko", "kucing"),
        Kana(25, KanaType.HIRAGANA, "の", "no", "のみもの", "nomimono", "minuman"),

        // ha
        Kana(26, KanaType.HIRAGANA, "は", "ha", "はな", "hana", "bunga"),
        Kana(27, KanaType.HIRAGANA, "ひ", "hi", "ひと", "hito", "orang"),
        Kana(28, KanaType.HIRAGANA, "ふ", "fu", "ふゆ", "fuyu", "musim dingin"),
        Kana(29, KanaType.HIRAGANA, "へ", "he", "へや", "heya", "kamar"),
        Kana(30, KanaType.HIRAGANA, "ほ", "ho", "ほん", "hon", "buku"),

        // ma
        Kana(31, KanaType.HIRAGANA, "ま", "ma", "まど", "mado", "jendela"),
        Kana(32, KanaType.HIRAGANA, "み", "mi", "みず", "mizu", "air"),
        Kana(33, KanaType.HIRAGANA, "む", "mu", "むし", "mushi", "serangga"),
        Kana(34, KanaType.HIRAGANA, "め", "me", "め", "me", "mata"),
        Kana(35, KanaType.HIRAGANA, "も", "mo", "もり", "mori", "hutan"),

        // ya
        Kana(36, KanaType.HIRAGANA, "や", "ya", "やま", "yama", "gunung"),
        Kana(37, KanaType.HIRAGANA, "ゆ", "yu", "ゆき", "yuki", "salju"),
        Kana(38, KanaType.HIRAGANA, "よ", "yo", "よる", "yoru", "malam"),

        // ra
        Kana(39, KanaType.HIRAGANA, "ら", "ra", "らいねん", "rainen", "tahun depan"),
        Kana(40, KanaType.HIRAGANA, "り", "ri", "りんご", "ringo", "apel"),
        Kana(41, KanaType.HIRAGANA, "る", "ru", "るす", "rusu", "tidak di rumah"),
        Kana(42, KanaType.HIRAGANA, "れ", "re", "れい", "rei", "nol"),
        Kana(43, KanaType.HIRAGANA, "ろ", "ro", "ろく", "roku", "enam"),

        // wa + n
        Kana(44, KanaType.HIRAGANA, "わ", "wa", "わたし", "watashi", "saya"),
        Kana(45, KanaType.HIRAGANA, "を", "wo", "ごはんをたべる", "gohan wo taberu", "makan nasi"),
        Kana(46, KanaType.HIRAGANA, "ん", "n", "ほん", "hon", "buku")
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