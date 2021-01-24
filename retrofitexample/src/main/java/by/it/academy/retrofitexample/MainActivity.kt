package by.it.academy.retrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity : AppCompatActivity() {

    private val retrofit by lazy {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val newsApi = retrofit.create(NewsApi::class.java)
        val newsApiCall = newsApi.getTopHeadLines("us")
        newsApiCall.enqueue(object: Callback<NewsRootObject>{
            override fun onFailure(call: Call<NewsRootObject>, t: Throwable) {
                Log.d("RETROFIT_NEWS", t.toString())
                Log.d("RETROFIT_NEWS", Thread.currentThread().name)
            }

            override fun onResponse(call: Call<NewsRootObject>, response: Response<NewsRootObject>) {
                Log.d("RETROFIT_NEWS", response.body().toString())
                Log.d("RETROFIT_NEWS", Thread.currentThread().name)
            }
        })
    }
}