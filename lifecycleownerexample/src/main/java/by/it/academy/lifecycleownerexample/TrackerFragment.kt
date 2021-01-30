package by.it.academy.lifecycleownerexample

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class TrackerFragment: Fragment() {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewLifecycleOwner.lifecycle
            .addObserver(AnalyticsTrackerLifecycle("MAIN_ACTIVITY"))
    }
}