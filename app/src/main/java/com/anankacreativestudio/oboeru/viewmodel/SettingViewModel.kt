package com.anankacreativestudio.oboeru.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.anankacreativestudio.oboeru.settings.NotificationScheduler
import com.anankacreativestudio.oboeru.utils.SettingsPreferences
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context,
    private val settingsPreferences: SettingsPreferences
) : ViewModel() {

    val notificationEnabled = settingsPreferences.notificationEnabled
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
           false
        )

    val soundEnabled = settingsPreferences.soundEnabled
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5_000),
            true
        )

    fun onNotificationToggle(enabled: Boolean) {
        viewModelScope.launch {
            settingsPreferences.setNotificationEnabled(enabled)
            if (enabled) {
                NotificationScheduler.start(context)
            } else {
                NotificationScheduler.stop(context)
            }
        }
    }

    fun onSoundToggle(enabled: Boolean) {
        viewModelScope.launch {
            settingsPreferences.setSoundEnabled(enabled)
        }
    }
}