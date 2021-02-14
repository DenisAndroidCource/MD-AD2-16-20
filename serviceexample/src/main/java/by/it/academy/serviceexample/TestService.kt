package by.it.academy.serviceexample

import android.app.Service
import android.content.Intent
import android.os.Binder
import android.os.IBinder
import android.util.Log
import androidx.core.app.NotificationCompat
import java.util.concurrent.TimeUnit
import kotlin.random.Random

const val TAG = "TestService"
const val EXTRA_KEY = "EXTRA_KEY"

class TestService : Service() {

    private val binder = TestServiceBinder()
    private var data: Int? = null

    override fun onCreate() {
        super.onCreate()
        Log.d(TAG, "onCreate")
    }

    private fun showServiceNotification() {
        val notification = NotificationCompat.Builder(baseContext, "CHANNEL_ID")
            .setSmallIcon(R.drawable.ic_baseline_explore_24)
            .setContentTitle("TestService is working")
            .setContentText("The service has been started in tha background")
            .build()
        startForeground(5, notification)
    }

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Log.d(TAG, "onStartCommand startId: $startId")
        showServiceNotification()
        data = intent?.getIntExtra(EXTRA_KEY, 0)
//        Log.d(TAG, "onStartCommand value: $value")
//        if (value.rem(3) == 0) {
//            Log.d(TAG, "onStartCommand. The service stopped")
//            stopSelf()
//        }
//        stopSelf(4)
//        someJob(startId)
        return START_STICKY
    }

    override fun onDestroy() {
        super.onDestroy()
        Log.d(TAG, "onDestroy")
    }

    private fun someJob(startId: Int) {
        val runnable = Runnable {
            val sleep = Random(0).nextLong(0, 5)
            Log.d(TAG, "Thread started with startId: $startId sleep: $sleep")
            TimeUnit.SECONDS.sleep(sleep)
            Log.d(TAG, "Thread woke up with startId: $startId")
            stopSelf(2)
        }
        Thread(runnable).start()
    }

    override fun onBind(intent: Intent?): IBinder? = binder

    inner class TestServiceBinder : Binder() {
        fun getData() = data
    }
}