package com.anankacreativestudio.oboeru.repository

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.material.icons.filled.AutoStories
import androidx.compose.material.icons.filled.SyncAlt
import androidx.compose.material.icons.filled.Timer
import com.anankacreativestudio.oboeru.models.PracticeMode
import javax.inject.Inject

class MainRepository @Inject constructor() {

    val practiceModes = listOf(
        PracticeMode(
            id = "kana_recall",
            title = "Kana Recall",
            description = "Choose the correct romaji for each kana",
            icon = Icons.Default.AutoStories
        ),
        PracticeMode(
            id = "reverse_recall",
            title = "Reverse Recall",
            description = "Pick the correct kana from romaji",
            icon = Icons.Default.SyncAlt
        ),
        PracticeMode(
            id = "listening",
            title = "Listening Practice",
            description = "Listen and choose the correct kana",
            icon = Icons.AutoMirrored.Filled.VolumeUp
        ),
        PracticeMode(
            id = "speed_round",
            title = "Speed Round",
            description = "Answer as many as you can in 60 seconds",
            icon = Icons.Default.Timer
        )
    )
}