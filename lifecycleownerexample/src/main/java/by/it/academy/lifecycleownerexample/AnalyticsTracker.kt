package by.it.academy.lifecycleownerexample

import android.util.Log

class AnalyticsTracker {
    fun sendTime(screenName: String, time: Long) {
        Log.d("AnalyticsTracker", "Time in milliseconds on $screenName is $time")
    }
}