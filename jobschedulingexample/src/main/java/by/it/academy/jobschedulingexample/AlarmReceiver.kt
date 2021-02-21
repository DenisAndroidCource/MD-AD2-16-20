package by.it.academy.jobschedulingexample

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.os.Build
import androidx.core.app.NotificationCompat

private val NOTIFICATION_CHANNEL_ID = "NOTIFICATION_CHANNEL_ID"

class AlarmReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context?, intent: Intent?) {
        context?.run {
            createNotificationChannel(this)
            createNotification(context)
        }
    }

    private fun createNotification(context: Context) {
        val notification = NotificationCompat.Builder(context, NOTIFICATION_CHANNEL_ID)
            .setContentText("CONTENT TEXT")
            .setContentTitle("CONTENT TITLE")
            .setSmallIcon(R.drawable.ic_baseline_explore_24)
            .build()
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        notificationManager.notify(1, notification)
    }

    private fun createNotificationChannel(context: Context) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel(
                NOTIFICATION_CHANNEL_ID,
                "Default channel",
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationChannel.description = "Default channel to show notifications"

            val notificationManager =
                context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannel(notificationChannel)
        }
    }

}