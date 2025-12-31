package com.anankacreativestudio.oboeru.ui.screen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.anankacreativestudio.oboeru.ui.component.HeaderPageWithBack
import com.anankacreativestudio.oboeru.ui.component.NotificationToggleItem
import com.anankacreativestudio.oboeru.ui.component.SoundToggleItem
import com.anankacreativestudio.oboeru.viewmodel.SettingViewModel

@Composable
fun SettingScreen(
    onBackClick: () -> Unit = {}
) {
    val viewModel: SettingViewModel = hiltViewModel()
    val colors = MaterialTheme.colorScheme

    val notificationEnabled by viewModel.notificationEnabled.collectAsState()

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
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
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
                NotificationToggleItem(
                    isEnabled = notificationEnabled,
                    onCheckedChange = { enabled ->
                        viewModel.onNotificationToggle(enabled)
                    }
                )
            }
            item {
                SoundToggleItem()
            }
        }
    }
}