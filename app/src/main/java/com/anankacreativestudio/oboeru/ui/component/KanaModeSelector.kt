package com.anankacreativestudio.oboeru.ui.component

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.FilterChip
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import com.anankacreativestudio.oboeru.utils.KanaMode

@Composable
fun KanaModeSelector(
    selected: KanaMode,
    onSelected: (KanaMode) -> Unit
) {
    val options = listOf(
        KanaMode.HIRAGANA to "Hiragana",
        KanaMode.KATAKANA to "Katakana",
        KanaMode.RANDOM to "Random"
    )

    Row(
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {
        options.forEach { (mode, label) ->
            FilterChip(
                selected = selected == mode,
                label = {
                    Text(
                        text = label
                    )
                },
                onClick = {
                    onSelected(mode)
                }
            )
        }
    }
}