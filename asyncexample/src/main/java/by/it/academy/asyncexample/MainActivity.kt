package by.it.academy.asyncexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private val thread = Thread {
        val list = mutableListOf<Int>()
        while (Thread.interrupted()) {
            list.add(123)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        thread.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        thread.interrupt()
    }
}