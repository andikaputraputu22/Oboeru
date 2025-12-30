package com.anankacreativestudio.oboeru.settings

import android.content.Context
import androidx.work.ExistingWorkPolicy
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import com.anankacreativestudio.oboeru.notification.QuizNotificationWorker
import java.util.concurrent.TimeUnit

object NotificationScheduler {

    fun start(context: Context) {
        val request = OneTimeWorkRequestBuilder<QuizNotificationWorker>()
            .setInitialDelay(1, TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(context)
            .enqueueUniqueWork(
                "quiz_notification",
                ExistingWorkPolicy.REPLACE,
                request
            )
    }

    fun stop(context: Context) {
        WorkManager.getInstance(context)
            .cancelUniqueWork("quiz_notification")
    }
}