package by.it.academy.broadcastreceiverexampleextra

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.sendAction).setOnClickListener {
            sendCustomAction()
        }
    }

    private fun sendCustomAction() {
        val intent = Intent().apply {
            action = "by.it.academy.broadcastreceiverexample.CUSTOM_ACTION"
            putExtra("DATA", "HELLO LOGS")
        }

        sendBroadcast(intent)
    }
}