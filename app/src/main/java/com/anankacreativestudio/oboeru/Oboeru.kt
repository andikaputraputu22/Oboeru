/*
 * =====================================================
 * OBOERU - ANDROID APPLICATION
 * =====================================================
 * Developer: Ananka Creative Studio
 * Contact: 081339891936
 * © 2026 - All Rights Reserved
 *
 * PENTING: Credit developer tidak boleh dihapus
 * Untuk support & custom development hubungi developer
 * =====================================================
 */

package com.anankacreativestudio.oboeru

import android.app.Application
import android.util.Log
import androidx.hilt.work.HiltWorkerFactory
import androidx.work.Configuration
import com.anankacreativestudio.oboeru.notification.NotificationUtil
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class Oboeru : Application(), Configuration.Provider {

    @Inject
    lateinit var notificationUtil: NotificationUtil

    @Inject
    lateinit var workerFactory: HiltWorkerFactory

    override fun onCreate() {
        super.onCreate()
        notificationUtil.createChannel()
    }

    override val workManagerConfiguration: Configuration
        get() = Configuration.Builder()
            .setWorkerFactory(workerFactory)
            .setMinimumLoggingLevel(Log.DEBUG)
            .build()
}