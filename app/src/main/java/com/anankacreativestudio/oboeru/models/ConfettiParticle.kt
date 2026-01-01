package com.anankacreativestudio.oboeru.models

import androidx.compose.ui.graphics.Color

data class ConfettiParticle(
    val x: Float,
    val y: Float,
    val size: Float,
    val color: Color,
    val velocityX: Float,
    val velocityY: Float
)
