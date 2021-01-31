package by.it.academy.newsnetworkmvvmexample.data.datasouce.network

import by.it.academy.newsnetworkmvvmexample.data.datasouce.NewsDataSource
import by.it.academy.newsnetworkmvvmexample.data.datasouce.NewsInfoData
import by.it.academy.newsnetworkmvvmexample.data.datasouce.network.ApiController.RetrofitHolder.retrofit
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiController : NewsDataSource {

    override fun getTopHeadLines(country: String): Single<NewsInfoData> =
        retrofit.create(NewsApi::class.java).getTopHeadLines(country)
            .subscribeOn(Schedulers.io())

    private object RetrofitHolder {
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }
}