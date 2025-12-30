package com.anankacreativestudio.oboeru.notification

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager
import androidx.work.WorkerParameters
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import java.util.concurrent.TimeUnit

@HiltWorker
class QuizNotificationWorker @AssistedInject constructor(
    @Assisted context: Context,
    @Assisted params: WorkerParameters,
    private val notificationUtil: NotificationUtil
) : CoroutineWorker(context, params) {

    override suspend fun doWork(): Result {
        notificationUtil.showQuizNotification()
        scheduleNext()
        return Result.success()
    }

    private fun scheduleNext() {
        val delayMinutes = (10..20).random()
        val request = OneTimeWorkRequestBuilder<QuizNotificationWorker>()
            .setInitialDelay(delayMinutes.toLong(), TimeUnit.MINUTES)
            .build()

        WorkManager.getInstance(applicationContext).enqueue(request)
    }
}