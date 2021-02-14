package by.it.academy.serviceexample

import android.content.ComponentName
import android.content.Context
import android.content.Intent
import android.content.ServiceConnection
import android.os.Bundle
import android.os.IBinder
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val random = Random(0)
    private var serviceBinder: TestService.TestServiceBinder? = null

    private val serviceConnection = object : ServiceConnection {
        override fun onServiceConnected(name: ComponentName?, service: IBinder?) {
            serviceBinder = service as TestService.TestServiceBinder
            Log.d(TAG, "BINNED SERVICE ${serviceBinder?.getData()}")
        }

        override fun onServiceDisconnected(name: ComponentName?) {
            serviceBinder = null
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startService).setOnClickListener {
            val intent = Intent(this, TestService::class.java).apply {
                putExtra(EXTRA_KEY, random.nextInt(0, 10))
            }
            startService(intent)
        }
        findViewById<Button>(R.id.stopService).setOnClickListener {
            val intent = Intent(this, TestService::class.java)
            stopService(intent)
        }

        findViewById<Button>(R.id.bindService).setOnClickListener {
            val intent = Intent(this, TestService::class.java)
            bindService(intent, serviceConnection, Context.BIND_AUTO_CREATE)
        }

        findViewById<Button>(R.id.unbindService).setOnClickListener {
            serviceBinder = null
            unbindService(serviceConnection)
        }
    }
}