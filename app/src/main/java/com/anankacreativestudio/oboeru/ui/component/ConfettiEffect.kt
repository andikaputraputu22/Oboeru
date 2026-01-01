package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.runtime.withFrameNanos
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.unit.IntSize
import com.anankacreativestudio.oboeru.models.ConfettiParticle
import kotlin.random.Random

@Composable
fun ConfettiEffect(
    modifier: Modifier = Modifier,
    trigger: Boolean,
    durationMillis: Long = 900L,
    particleCount: Int = 40
) {
    if (!trigger) return

    val particles = remember { mutableStateListOf<ConfettiParticle>() }
    var canvasSize by remember { mutableStateOf(IntSize.Zero) }

    LaunchedEffect(trigger) {
        if (!trigger) return@LaunchedEffect
        particles.clear()

        repeat(particleCount) {
            particles += ConfettiParticle(
                x = Random.nextFloat() * canvasSize.width,
                y = -20f,
                size = Random.nextFloat() * 10f + 6f,
                color = listOf(
                    Color(0xFFFFC107),
                    Color(0xFF4CAF50),
                    Color(0xFF03A9F4),
                    Color(0xFFE91E63),
                    Color(0xFF9C27B0)
                ).random(),
                velocityX = Random.nextFloat() * 6f - 3f,
                velocityY = Random.nextFloat() * 10f + 6f
            )
        }

        val startTime = withFrameNanos { it }
        while (withFrameNanos { it } - startTime < durationMillis * 1_000_000) {
            particles.replaceAll { p ->
                p.copy(
                    x = p.x + p.velocityX,
                    y = p.y + p.velocityY
                )
            }
        }
        particles.clear()
    }

    Canvas(
        modifier = modifier
            .fillMaxSize()
            .onSizeChanged { canvasSize = it }
    ) {
        particles.forEach { particle ->
            drawRect(
                color = particle.color,
                topLeft = Offset(particle.x, particle.y),
                size = Size(particle.size, particle.size)
            )
        }
    }
}