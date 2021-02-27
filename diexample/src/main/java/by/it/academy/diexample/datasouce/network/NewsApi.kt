package by.it.academy.diexample.datasouce.network

import by.it.academy.diexample.datasouce.NewsInfoDataModel
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface NewsApi {
    @Headers("X-Api-Key:fe27628816ba4ca5b23fe932cf36e26e")
    @GET("v2/top-headlines")
    fun getTopHeadLines(@Query("country") country: String): Single<NewsInfoDataModel>
}