package com.anankacreativestudio.oboeru.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.anankacreativestudio.oboeru.ui.component.HeaderPageWithBack
import com.anankacreativestudio.oboeru.ui.component.NotificationToggleItem
import com.anankacreativestudio.oboeru.ui.component.SoundToggleItem

@Composable
fun SettingScreen(
    onBackClick: () -> Unit = {}
) {
    val colors = MaterialTheme.colorScheme

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, bottom = 24.dp, start = 16.dp, end = 16.dp),
                color = colors.background
            ) {
                HeaderPageWithBack(
                    title = "Settings",
                    onBackClick = onBackClick
                )
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(vertical = 8.dp)
        ) {
            item {
                NotificationToggleItem()
            }
            item {
                SoundToggleItem()
            }
        }
    }
}