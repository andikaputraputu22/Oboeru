package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun AnswerFeedback(
    isCorrect: Boolean
) {
    val scale by animateFloatAsState(
        targetValue = if (isCorrect) 1.2f else 1f,
        animationSpec = tween(300),
        label = ""
    )

    val offsetX by animateDpAsState(
        targetValue = if (!isCorrect) 8.dp else 0.dp,
        animationSpec = tween(80),
        label = ""
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .offset(x = offsetX)
            .scale(scale = scale),
        contentAlignment = Alignment.Center
    ) {
        Text(
            text = if (isCorrect) "✔ Correct!" else "✖ Wrong!",
            color = if (isCorrect) Color(0xFF2E7D32) else Color.Red,
            fontSize = 32.sp,
            fontWeight = FontWeight.Bold
        )
    }
}