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
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.anankacreativestudio.oboeru.ui.component.HeaderPage
import com.anankacreativestudio.oboeru.ui.component.KanaItem
import com.anankacreativestudio.oboeru.viewmodel.HiraganaViewModel

@Composable
fun HiraganaScreen(
    title: String,
    onMenuClick: () -> Unit = {}
) {
    val viewModel: HiraganaViewModel = hiltViewModel()
    val colors = MaterialTheme.colorScheme
    val hiraganaList = viewModel.hiraganaList

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
                items = hiraganaList,
                key = { it.id }
            ) { kana ->
                KanaItem(
                    kana = kana.kana,
                    romaji = kana.romaji
                )
            }
        }
    }
}