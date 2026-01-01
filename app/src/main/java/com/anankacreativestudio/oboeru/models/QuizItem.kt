package com.anankacreativestudio.oboeru.models

data class QuizItem(
    val question: String,
    val correctAnswer: String,
    val choices: List<String>,
    val reading: String
)
