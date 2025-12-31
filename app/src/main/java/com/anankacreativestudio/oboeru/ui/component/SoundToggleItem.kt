package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun SoundToggleItem() {
    var enabled by rememberSaveable { mutableStateOf(false) }

    SettingSwitchItem(
        title = "Sound",
        description = "Play pronunciation when tapping kana",
        icon = if (enabled) {
            Icons.AutoMirrored.Filled.VolumeUp
        } else {
            Icons.AutoMirrored.Filled.VolumeOff
        },
        checked = enabled,
        onCheckedChange = { enabled = it }
    )
}