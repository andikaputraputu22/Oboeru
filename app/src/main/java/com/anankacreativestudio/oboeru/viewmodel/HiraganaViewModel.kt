package com.anankacreativestudio.oboeru.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anankacreativestudio.oboeru.models.Kana
import com.anankacreativestudio.oboeru.repository.KanaRepository
import com.anankacreativestudio.oboeru.utils.SettingsPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HiraganaViewModel @Inject constructor(
    private val kanaRepository: KanaRepository,
    private val settingsPreferences: SettingsPreferences
) : ViewModel() {

    val hiraganaList: List<Kana> = kanaRepository.hiraganaList

    val soundEnabled = settingsPreferences.soundEnabled
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            true
        )
}