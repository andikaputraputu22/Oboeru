package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.NotificationsOff
import androidx.compose.runtime.Composable

@Composable
fun NotificationToggleItem(
    isEnabled: Boolean,
    onCheckedChange: (Boolean) -> Unit
) {
    SettingSwitchItem(
        title = "Daily Recall",
        description = "Get daily notification to practice kana",
        icon = if (isEnabled) {
            Icons.Default.Notifications
        } else {
            Icons.Default.NotificationsOff
        },
        checked = isEnabled,
        onCheckedChange = onCheckedChange
    )
}