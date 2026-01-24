package com.anankacreativestudio.oboeru.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.imePadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.anankacreativestudio.oboeru.models.Kana
import com.anankacreativestudio.oboeru.ui.component.HeaderPage
import com.anankacreativestudio.oboeru.ui.component.KanaDetailBottomSheet
import com.anankacreativestudio.oboeru.ui.component.KanaItem
import com.anankacreativestudio.oboeru.utils.rememberTextToSpeech
import com.anankacreativestudio.oboeru.viewmodel.KatakanaViewModel

@Composable
fun KatakanaScreen(
    title: String,
    onMenuClick: () -> Unit = {}
) {
    val viewModel: KatakanaViewModel = hiltViewModel()
    val colors = MaterialTheme.colorScheme
    val katakanaList = viewModel.katakanaList
    val soundEnabled by viewModel.soundEnabled.collectAsStateWithLifecycle()

    var selectedKana by remember { mutableStateOf<Kana?>(null) }
    val isTtsReady = remember { mutableStateOf(false) }

    val speak = rememberTextToSpeech { ready ->
        isTtsReady.value = ready
    }

    Scaffold(
        modifier = Modifier
            .fillMaxSize()
            .imePadding(),
        topBar = {
            Surface(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 48.dp, start = 16.dp, end = 16.dp)
                    .background(color = colors.background)
            ) {
                HeaderPage(
                    title = title,
                    onMenuClick = onMenuClick
                )
            }
        }
    ) { innerPadding ->
        LazyVerticalGrid(
            columns = GridCells.Fixed(3),
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            items(
                items = katakanaList,
                key = { it.id }
            ) { kana ->
                KanaItem(
                    kana = kana.kana,
                    romaji = kana.romaji,
                    onClick = {
                        selectedKana = kana
                    }
                )
            }
        }
    }

    selectedKana?.let { kana ->
        KanaDetailBottomSheet(
            kana = kana,
            soundEnabled = isTtsReady.value,
            onPlaySound = {
                if (soundEnabled) {
                    kana.exampleKana?.let { speak(it) }
                }
            },
            onDismiss = {
                selectedKana = null
            }
        )
    }
}