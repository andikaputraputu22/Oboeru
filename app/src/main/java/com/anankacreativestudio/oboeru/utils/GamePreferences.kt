package com.anankacreativestudio.oboeru.utils

import android.content.Context
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class GamePreferences @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    private val prefSpeedRoundHighScore =
        intPreferencesKey("speed_round_high_score")

    val speedRoundHighScore: Flow<Int> =
        context.dataStore.data.map { prefs ->
            prefs[prefSpeedRoundHighScore] ?: 0
        }

    suspend fun updateHighScoreIfNeeded(score: Int) {
        context.dataStore.edit { prefs ->
            val current = prefs[prefSpeedRoundHighScore] ?: 0
            if (score > current) {
                prefs[prefSpeedRoundHighScore] = score
            }
        }
    }
}