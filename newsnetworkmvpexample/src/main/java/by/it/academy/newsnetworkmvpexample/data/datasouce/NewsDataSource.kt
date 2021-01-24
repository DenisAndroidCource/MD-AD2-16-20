package by.it.academy.newsnetworkmvpexample.data.datasouce

import io.reactivex.Single

interface NewsDataSource {
    fun getTopHeadLines(country: String): Single<NewsInfoData>
}