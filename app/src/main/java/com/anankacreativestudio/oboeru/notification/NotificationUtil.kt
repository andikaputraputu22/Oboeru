package com.anankacreativestudio.oboeru.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import com.anankacreativestudio.oboeru.MainActivity
import com.anankacreativestudio.oboeru.QuizActivity
import com.anankacreativestudio.oboeru.R
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class NotificationUtil @Inject constructor(
    @param:ApplicationContext private val context: Context
) {

    companion object {
        const val CHANNEL_ID = "quiz_channel"
    }

    fun createChannel() {
        val channel = NotificationChannel(
            CHANNEL_ID,
            "Daily Practice",
            NotificationManager.IMPORTANCE_DEFAULT
        ).apply {
            description = "Oboeru quiz notification"
        }

        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.createNotificationChannel(channel)
    }

    fun showQuizNotification() {
        val intent = Intent(context, QuizActivity::class.java).apply {
            flags = Intent.FLAG_ACTIVITY_NEW_TASK
        }

        val pendingIntent = PendingIntent.getActivity(
            context,
            0,
            intent,
            PendingIntent.FLAG_UPDATE_CURRENT or PendingIntent.FLAG_IMMUTABLE
        )

        val notification = NotificationCompat.Builder(context, CHANNEL_ID)
            .setSmallIcon(R.drawable.ic_notification)
            .setContentTitle("Oboeru")
            .setContentText("Come on, let's practice!")
            .setContentIntent(pendingIntent)
            .setAutoCancel(true)
            .build()

        val manager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(System.currentTimeMillis().toInt(), notification)
    }
}