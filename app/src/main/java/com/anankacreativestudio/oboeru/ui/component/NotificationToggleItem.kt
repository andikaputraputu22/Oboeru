package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue

@Composable
fun NotificationToggleItem() {
    var enabled by rememberSaveable { mutableStateOf(true) }

    SettingSwitchItem(
        title = "Daily Recall",
        description = "Get daily notification to practice kana",
        icon = if (enabled) {
            Icons.Default.Notifications
        } else {
            Icons.Default.NotificationsOff
        },
        checked = enabled,
        onCheckedChange = { enabled = it }
    )
}