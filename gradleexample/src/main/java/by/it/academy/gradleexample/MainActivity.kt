package by.it.academy.gradleexample

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log

// myapp.com
// test.myapp.com

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.d("GRADLE_", BuildConfig.SERVER_DOMAIN)
        Log.d("GRADLE_", AdsController().showPromoMessage())
    }
}