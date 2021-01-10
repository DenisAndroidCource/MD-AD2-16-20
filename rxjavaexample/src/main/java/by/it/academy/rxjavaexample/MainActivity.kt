package by.it.academy.rxjavaexample

import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.core.Observable
import io.reactivex.rxjava3.functions.Action
import io.reactivex.rxjava3.functions.Consumer
import io.reactivex.rxjava3.schedulers.Schedulers

class Result<T>(data: T?)

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val disposable = Observable.just(1, 0, -10, 56, -110)
            .filter { number -> number >= 0 }
            .subscribeOn(Schedulers.computation())
            .map { number -> number.toString() }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { result -> findViewById<TextView>(R.id.text).text = result },
                { error -> Log.d("RXJAVA_EX", error.toString()) },
                { Log.d("RXJAVA_EX", "ON COMPLETE") }
            )

//        val disposable: Disposable = observale.map { number -> number * number }
//            .subscribe {
//                Consumer<String> { result -> Log.d("RXJAVA_EX", result) }
//                Consumer<Throwable> { error -> Log.d("RXJAVA_EX", error.toString())}
//                Action { Log.d("RXJAVA_EX", "ON COMPLETE") }
//            }

//        DisposableContainer
//        disposable.dispose()
    }
}