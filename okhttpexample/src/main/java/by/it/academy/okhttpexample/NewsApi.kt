package by.it.academy.okhttpexample

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {
    @GET("v2/top-headlines")
    fun getTopHeadLines(
        @Query("country") country: String,
        @Query("apiKey") apiKey: String
    ): Call<NewsRootObject>
}