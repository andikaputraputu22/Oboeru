package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.keyframes
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.tween
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Close
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun QuizChoiceItem(
    text: String,
    enabled: Boolean,
    backgroundColor: Color,
    textColor: Color,
    isSelected: Boolean,
    isCorrectAnswer: Boolean,
    showResult: Boolean,
    onClick: () -> Unit
) {
    val shakeOffset = remember { Animatable(0f) }

    val scale by animateFloatAsState(
        targetValue = if (showResult && isCorrectAnswer) 1.05f else 1f,
        animationSpec = spring(
            dampingRatio = Spring.DampingRatioMediumBouncy,
            stiffness = Spring.StiffnessLow
        ),
        label = "pulse"
    )

    val iconScale by animateFloatAsState(
        targetValue = if (showResult) 1f else 0f,
        animationSpec = tween(300),
        label = "iconScale"
    )

    val iconAlpha by animateFloatAsState(
        targetValue = if (showResult) 1f else 0f,
        animationSpec = tween(300),
        label = "iconAlpha"
    )

    LaunchedEffect(showResult) {
        if (showResult && isSelected && !isCorrectAnswer) {
            shakeOffset.animateTo(
                targetValue = 0f,
                animationSpec = keyframes {
                    durationMillis = 400
                    (-16f) at 50
                    (16f) at 100
                    (-12f) at 150
                    (12f) at 200
                    (-6f) at 250
                    (6f) at 300
                    0f at 400
                }
            )
        }
    }

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 6.dp)
            .graphicsLayer {
                translationX = shakeOffset.value
                scaleX = scale
                scaleY = scale
            }
            .clickable(
                enabled = enabled,
                onClick = onClick
            ),
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        )
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
        ) {
            if (showResult && (isSelected || isCorrectAnswer)) {
                Icon(
                    imageVector = if (isCorrectAnswer) {
                        Icons.Default.Check
                    } else {
                        Icons.Default.Close
                    },
                    contentDescription = null,
                    tint = Color.Black,
                    modifier = Modifier
                        .align(Alignment.CenterStart)
                        .graphicsLayer {
                            scaleX = iconScale
                            scaleY = iconScale
                            alpha = iconAlpha
                        }
                )
            }
            Text(
                text = text,
                color = textColor,
                fontSize = 18.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier
                    .align(Alignment.Center)
            )
        }
    }
}