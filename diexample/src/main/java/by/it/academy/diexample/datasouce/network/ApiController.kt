package by.it.academy.diexample.datasouce.network

import by.it.academy.diexample.datasouce.NewsDataSource
import by.it.academy.diexample.datasouce.NewsInfoDataModel
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import retrofit2.Retrofit

class ApiController(private val retrofit: Retrofit) : NewsDataSource {

    override fun getTopHeadLines(country: String): Single<NewsInfoDataModel> =
        retrofit.create(NewsApi::class.java).getTopHeadLines(country)
            .subscribeOn(Schedulers.io())
}