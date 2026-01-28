package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeDrawing
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.windowInsetsPadding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anankacreativestudio.oboeru.utils.Screen

@Composable
fun DrawerLayout(
    currentRoute: String?,
    onItemClick: (String) -> Unit
) {
    val colors = MaterialTheme.colorScheme

    Box(
        modifier = Modifier
            .width(300.dp)
            .fillMaxHeight()
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .background(colors.surface)
                .windowInsetsPadding(WindowInsets.safeDrawing)
                .padding(16.dp)
        ) {
            Text(
                text = "Learn",
                style = MaterialTheme.typography.labelMedium,
                color = colors.onSurfaceVariant,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            Spacer(modifier = Modifier.height(8.dp))
            DrawerItem(
                kana = "ひ",
                title = "Hiragana",
                selected = currentRoute == Screen.Hiragana.route,
                onClick = {
                    onItemClick(Screen.Hiragana.route)
                }
            )
            DrawerItem(
                kana = "カ",
                title = "Katakana",
                selected = currentRoute == Screen.Katakana.route,
                onClick = {
                    onItemClick(Screen.Katakana.route)
                }
            )
            DrawerItem(
                kana = "語",
                title = "Kotoba",
                selected = currentRoute == Screen.Kotoba.route,
                onClick = {
                    //
                }
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = "Menu",
                style = MaterialTheme.typography.labelMedium,
                color = colors.onSurfaceVariant,
                modifier = Modifier
                    .padding(horizontal = 16.dp, vertical = 8.dp)
            )
            DrawerItem(
                kana = "練",
                title = "Practice",
                selected = currentRoute == Screen.Practice.route,
                onClick = {
                    onItemClick(Screen.Practice.route)
                }
            )
            DrawerItem(
                kana = "進",
                title = "Progress"
            )
            DrawerItem(
                kana = "設",
                title = "Settings",
                selected = currentRoute == Screen.Setting.route,
                onClick = {
                    onItemClick(Screen.Setting.route)
                }
            )
        }
    }
}