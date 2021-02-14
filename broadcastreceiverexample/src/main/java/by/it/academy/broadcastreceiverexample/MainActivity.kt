package by.it.academy.broadcastreceiverexample

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val receiver = TimeBroadcastReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sendAction).setOnClickListener {
            sendCustomAction()
        }

        registerTimeBroadcastReceiver()
    }

    private fun sendCustomAction() {
        val intent = Intent().apply {
            action = CUSTOM_ACTION
            putExtra("DATA", "HELLO LOGS")
        }

        sendBroadcast(intent)
    }

    private fun registerTimeBroadcastReceiver() {
        val intentFilter = IntentFilter().apply {
            addAction(Intent.ACTION_TIMEZONE_CHANGED)
            addAction(Intent.ACTION_TIME_CHANGED)
            addAction(CUSTOM_ACTION)
        }
        registerReceiver(receiver, intentFilter)
    }
}