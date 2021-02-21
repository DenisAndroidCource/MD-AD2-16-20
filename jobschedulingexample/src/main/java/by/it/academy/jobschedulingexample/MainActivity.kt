package by.it.academy.jobschedulingexample

import android.annotation.SuppressLint
import android.app.AlarmManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.net.Network
import android.os.Bundle
import android.os.SystemClock
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import androidx.work.Constraints
import androidx.work.NetworkType
import androidx.work.OneTimeWorkRequest
import androidx.work.PeriodicWorkRequest
import androidx.work.WorkManager
import java.util.concurrent.TimeUnit


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.button).setOnClickListener { scheduleWorker() }
    }

    private fun scheduleWorker() {
        val constraint = Constraints.Builder()
            .setRequiredNetworkType(NetworkType.NOT_ROAMING)
            .setRequiresCharging(true)
            .build()

        val workRequest = PeriodicWorkRequest.Builder(
            CustomWork::class.java, 20, TimeUnit.MINUTES)
            .setConstraints(constraint)
            .build()

        WorkManager.getInstance(this)
            .enqueue(workRequest)
    }

    private fun scheduleAlarm() {
        val intent = Intent(this, AlarmReceiver::class.java)
        val pendingIntent = PendingIntent.getBroadcast(
            this, 1000, intent, PendingIntent.FLAG_UPDATE_CURRENT
        )

        val alarmManager = getSystemService(Context.ALARM_SERVICE) as AlarmManager
        alarmManager.setInexactRepeating(
            AlarmManager.ELAPSED_REALTIME_WAKEUP,
            SystemClock.elapsedRealtime() + 1000,
            5000,
            pendingIntent
        )
    }
}