package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector

@Composable
fun ConfirmationDialog(
    title: String,
    description: String,
    confirmLabel: String,
    icon: ImageVector,
    onDismiss: () -> Unit,
    onConfirm: () -> Unit
) {
    AlertDialog(
        onDismissRequest = onDismiss,
        title = {
            Text(
                text = title,
                style = MaterialTheme.typography.titleLarge
            )
        },
        text = {
            Text(
                text = description,
                style = MaterialTheme.typography.bodyMedium
            )
        },
        icon = {
            Icon(
                imageVector = icon,
                contentDescription = null
            )
        },
        confirmButton = {
            TextButton(onClick = onConfirm) {
                Text(text = confirmLabel)
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text(text = "Cancel")
            }
        }
    )
}