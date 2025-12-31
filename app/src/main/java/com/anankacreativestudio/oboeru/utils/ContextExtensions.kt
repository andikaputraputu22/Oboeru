package com.anankacreativestudio.oboeru.utils

import android.content.Context
import androidx.datastore.preferences.preferencesDataStore

val Context.dataStore by preferencesDataStore("oboeru_prefs")