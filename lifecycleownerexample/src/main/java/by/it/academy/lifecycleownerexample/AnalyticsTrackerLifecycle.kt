package by.it.academy.lifecycleownerexample

import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleObserver
import androidx.lifecycle.OnLifecycleEvent
import java.util.Date

class AnalyticsTrackerLifecycle(
    private val screenName: String,
    private val analyticsTracker: AnalyticsTracker = AnalyticsTracker()
) : LifecycleObserver {

    private var startTime: Long = 0

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    fun screenStart() {
        startTime = Date().time
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    fun stopScreen() {
        analyticsTracker.sendTime(screenName, Date().time - startTime)
    }
}