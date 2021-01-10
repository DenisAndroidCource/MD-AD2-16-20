package by.it.academy.coroutinesexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Deferred
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

//    private val job: Job

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        CLazz().foo(object : FooCallback {
//            override fun onDataReceived(result: Boolean) {
//                CLazz().foo(object : FooCallback {
//                    override fun onDataReceived(result: Boolean) {
//                        CLazz().foo(object : FooCallback {
//                            override fun onDataReceived(result: Boolean) {
//                                CLazz().foo(object : FooCallback {
//                                    override fun onDataReceived(result: Boolean) {
//                                        CLazz().foo(object : FooCallback {
//                                            override fun onDataReceived(result: Boolean) {
//
//                                            }
//                                        })
//                                    }
//                                })
//                            }
//                        })
//                    }
//                })
//            }
//        })


        val job: Job = GlobalScope.launch {
            Log.d("KEY", Thread.currentThread().name)
            val deferred = async { CLazz().foo() }

            // some code

//            deferred.cancel()
            val result = deferred.await() // get result

            // some code

            val job = launch {  }

            launch(Dispatchers.Main) {  }
        }
    }

    override fun onDestroy() {
        super.onDestroy()

//        if (job.isActive) {
//            job.cancel()
//        }
    }
}

interface FooCallback {
    fun onDataReceived(result: Boolean)
}

class CLazz {

    suspend fun foo(): Boolean {
        Thread.sleep(500)
        return false;
    }

}