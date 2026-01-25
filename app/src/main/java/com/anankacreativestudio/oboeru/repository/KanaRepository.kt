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
        Kana(101, KanaType.KATAKANA, "ア", "a", "アメ", "ame", "permen"),
        Kana(102, KanaType.KATAKANA, "イ", "i", "イス", "isu", "kursi"),
        Kana(103, KanaType.KATAKANA, "ウ", "u", "ウサギ", "usagi", "kelinci"),
        Kana(104, KanaType.KATAKANA, "エ", "e", "エアコン", "eakon", "AC"),
        Kana(105, KanaType.KATAKANA, "オ", "o", "オレンジ", "orenji", "jeruk"),

        // ka
        Kana(106, KanaType.KATAKANA, "カ", "ka", "カメラ", "kamera", "kamera"),
        Kana(107, KanaType.KATAKANA, "キ", "ki", "キーボード", "kiiboodo", "keyboard"),
        Kana(108, KanaType.KATAKANA, "ク", "ku", "クラス", "kurasu", "kelas"),
        Kana(109, KanaType.KATAKANA, "ケ", "ke", "ケーキ", "keeki", "kue"),
        Kana(110, KanaType.KATAKANA, "コ", "ko", "コーヒー", "koohii", "kopi"),

        // sa
        Kana(111, KanaType.KATAKANA, "サ", "sa", "サラダ", "sarada", "salad"),
        Kana(112, KanaType.KATAKANA, "シ", "shi", "シャツ", "shatsu", "kaos/kemeja"),
        Kana(113, KanaType.KATAKANA, "ス", "su", "スーパー", "suupaa", "supermarket"),
        Kana(114, KanaType.KATAKANA, "セ", "se", "セーター", "seetaa", "sweater"),
        Kana(115, KanaType.KATAKANA, "ソ", "so", "ソファ", "sofa", "sofa"),

        // ta
        Kana(116, KanaType.KATAKANA, "タ", "ta", "タクシー", "takushii", "taksi"),
        Kana(117, KanaType.KATAKANA, "チ", "chi", "チーズ", "chiizu", "keju"),
        Kana(118, KanaType.KATAKANA, "ツ", "tsu", "ツアー", "tsuaa", "tur"),
        Kana(119, KanaType.KATAKANA, "テ", "te", "テレビ", "terebi", "televisi"),
        Kana(120, KanaType.KATAKANA, "ト", "to", "トマト", "tomato", "tomat"),

        // na
        Kana(121, KanaType.KATAKANA, "ナ", "na", "ナイフ", "naifu", "pisau"),
        Kana(122, KanaType.KATAKANA, "ニ", "ni", "ニュース", "nyuusu", "berita"),
        Kana(123, KanaType.KATAKANA, "ヌ", "nu", "ヌードル", "nuudoru", "mi"),
        Kana(124, KanaType.KATAKANA, "ネ", "ne", "ネクタイ", "nekutai", "dasi"),
        Kana(125, KanaType.KATAKANA, "ノ", "no", "ノート", "nooto", "buku catatan"),

        // ha
        Kana(126, KanaType.KATAKANA, "ハ", "ha", "ハンバーガー", "hanbaagaa", "hamburger"),
        Kana(127, KanaType.KATAKANA, "ヒ", "hi", "ヒーター", "hiitaa", "pemanas"),
        Kana(128, KanaType.KATAKANA, "フ", "fu", "フォーク", "fooku", "garpu"),
        Kana(129, KanaType.KATAKANA, "ヘ", "he", "ヘルメット", "herumetto", "helm"),
        Kana(130, KanaType.KATAKANA, "ホ", "ho", "ホテル", "hoteru", "hotel"),

        // ma
        Kana(131, KanaType.KATAKANA, "マ", "ma", "マスク", "masuku", "masker"),
        Kana(132, KanaType.KATAKANA, "ミ", "mi", "ミルク", "miruku", "susu"),
        Kana(133, KanaType.KATAKANA, "ム", "mu", "ムービー", "muubii", "film"),
        Kana(134, KanaType.KATAKANA, "メ", "me", "メール", "meeru", "email"),
        Kana(135, KanaType.KATAKANA, "モ", "mo", "モバイル", "mobairu", "ponsel"),

        // ya
        Kana(136, KanaType.KATAKANA, "ヤ", "ya", "ヤード", "yaado", "yard"),
        Kana(137, KanaType.KATAKANA, "ユ", "yu", "ユニフォーム", "yunifoomu", "seragam"),
        Kana(138, KanaType.KATAKANA, "ヨ", "yo", "ヨーグルト", "yooguruto", "yogurt"),

        // ra
        Kana(139, KanaType.KATAKANA, "ラ", "ra", "ラジオ", "rajio", "radio"),
        Kana(140, KanaType.KATAKANA, "リ", "ri", "リモコン", "rimokon", "remote"),
        Kana(141, KanaType.KATAKANA, "ル", "ru", "ルール", "ruuru", "aturan"),
        Kana(142, KanaType.KATAKANA, "レ", "re", "レモン", "remon", "lemon"),
        Kana(143, KanaType.KATAKANA, "ロ", "ro", "ロボット", "robotto", "robot"),

        // wa + n
        Kana(144, KanaType.KATAKANA, "ワ", "wa", "ワイン", "wain", "anggur (wine)"),
        Kana(145, KanaType.KATAKANA, "ヲ", "wo", "ヲタク", "otaku", "penggemar berat"),
        Kana(146, KanaType.KATAKANA, "ン", "n", "パン", "pan", "roti")
    )
}