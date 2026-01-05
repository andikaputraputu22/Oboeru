package com.anankacreativestudio.oboeru.utils

sealed class SpeedRoundEvent {

    data object Start: SpeedRoundEvent()
    data class SelectAnswer(val answer: String): SpeedRoundEvent()
    data object Tick: SpeedRoundEvent()
    data object Finish: SpeedRoundEvent()
}