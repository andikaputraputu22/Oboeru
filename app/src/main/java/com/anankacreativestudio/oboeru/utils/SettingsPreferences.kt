package com.anankacreativestudio.oboeru.utils

import android.content.Context
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class SettingsPreferences @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    private val prefNotificationEnabled =
        booleanPreferencesKey("notification_enabled")

    val notificationEnabled: Flow<Boolean> =
        context.dataStore.data.map { prefs ->
            prefs[prefNotificationEnabled] ?: false
        }

    suspend fun setNotificationEnabled(enabled: Boolean) {
        context.dataStore.edit { prefs ->
            prefs[prefNotificationEnabled] = enabled
        }
    }
}