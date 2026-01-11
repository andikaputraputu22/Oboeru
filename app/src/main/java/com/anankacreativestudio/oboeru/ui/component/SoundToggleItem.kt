package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.VolumeOff
import androidx.compose.material.icons.automirrored.filled.VolumeUp
import androidx.compose.runtime.Composable

@Composable
fun SoundToggleItem(
    isEnabled: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    SettingSwitchItem(
        title = "Pronunciation",
        description = "Play pronunciation when tapping kana",
        icon = if (isEnabled) {
            Icons.AutoMirrored.Filled.VolumeUp
        } else {
            Icons.AutoMirrored.Filled.VolumeOff
        },
        checked = isEnabled,
        onCheckedChange = onCheckedChange
    )
}