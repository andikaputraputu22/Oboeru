package com.anankacreativestudio.oboeru.utils

import com.anankacreativestudio.oboeru.models.QuizItem

sealed class SpeedRoundState {

    data object Loading: SpeedRoundState()

    data class Playing(
        val quiz: QuizItem,
        val remainingTime: Int,
        val score: Int
    ): SpeedRoundState()

    data class Finished(
        val score: Int
    ): SpeedRoundState()
}