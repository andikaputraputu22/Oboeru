package com.anankacreativestudio.oboeru.viewmodel

import android.content.Context
import androidx.lifecycle.ViewModel
import com.anankacreativestudio.oboeru.settings.NotificationScheduler
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class SettingViewModel @Inject constructor(
    @param:ApplicationContext private val context: Context
) : ViewModel() {

    private val _notificationEnabled = MutableStateFlow(false)
    val notificationEnabled: StateFlow<Boolean> = _notificationEnabled.asStateFlow()

    fun onNotificationToggle(enabled: Boolean) {
        _notificationEnabled.value = enabled
        if (enabled) {
            NotificationScheduler.start(context)
        } else {
            NotificationScheduler.stop(context)
        }
    }
}