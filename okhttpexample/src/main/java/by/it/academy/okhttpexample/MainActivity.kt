package by.it.academy.okhttpexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
//import com.google.gson.Gson
import okhttp3.Call
import okhttp3.Callback
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import org.json.JSONObject
import java.io.IOException

private const val URL =
    "https://newsapi.org/v2/top-headlines?country=us&apiKey=fe27628816ba4ca5b23fe932cf36e26e"

class MainActivity : AppCompatActivity() {

    private val httpClient = OkHttpClient()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getTopHeadlines()
    }

    private fun getTopHeadlines() {
        val request = Request.Builder()
            .url(URL)
            .build()

        val call = httpClient.newCall(request = request)
        call.enqueue(object : Callback {
            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    val json = response.body?.string()
                    Log.d("JSON", json ?: "")
//                    val newsObjectFromGSON =
//                        Gson().fromJson<NewsRootObject>(json, NewsRootObject::class.java)

                    json?.run {
                        val newsObject = jsonToNews(json)
                        Log.d("JSON", newsObject.toString())
                    }

                    Log.d("JSON",  "THREAD NAME: ${Thread.currentThread().name}")
                }
            }

            override fun onFailure(call: Call, e: IOException) {
                Log.d("JSON", e.toString())
            }
        })
    }

    private fun jsonToNews(json: String): NewsRootObject {
        val jsonObject = JSONObject(json)

        val jsonArray = jsonObject.getJSONArray("articles")

        val articleList = mutableListOf<Articles>()
        for (index in 0 until jsonArray.length()) {
            val arrayJsonObject = jsonArray.getJSONObject(index)

            val sourceJsonObject = arrayJsonObject.getJSONObject("source")
            val source = Source(
                id = sourceJsonObject.getString("id"),
                name = sourceJsonObject.getString("name")
            )

            val articles = Articles(
                author = arrayJsonObject.getString("author"),
                title = arrayJsonObject.getString("title"),
                description = arrayJsonObject.getString("description"),
                url = arrayJsonObject.getString("url"),
                urlToImage = arrayJsonObject.getString("urlToImage"),
                publishedAt = arrayJsonObject.getString("publishedAt"),
                content = arrayJsonObject.getString("content"),
                source = source
            )

            articleList.add(articles)
        }

        return NewsRootObject(
            status = jsonObject.getString("status"),
            totalResults = jsonObject.getInt("totalResults"),
            articles = articleList
        )
    }
}