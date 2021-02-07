package by.it.academy.newscleanarchitectureexample.datasouce.network

import by.it.academy.newscleanarchitectureexample.datasouce.NewsDataSource
import by.it.academy.newscleanarchitectureexample.datasouce.NewsInfoDataModel
import by.it.academy.newscleanarchitectureexample.datasouce.network.ApiController.RetrofitHolder.retrofit
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

class ApiController : NewsDataSource {

    override fun getTopHeadLines(country: String): Single<NewsInfoDataModel> =
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