package by.it.academy.broadcastreceiverexample

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

private const val TAG = "TimeBroadcastReceiver"

const val CUSTOM_ACTION = "by.it.academy.broadcastreceiverexample.CUSTOM_ACTION"

class TimeBroadcastReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val action = intent?.action ?: ""
        Log.d(TAG, action)
        if (action == CUSTOM_ACTION) {
            Log.d(TAG, "DATA ${intent.getStringExtra("DATA")}")
        }
    }
}