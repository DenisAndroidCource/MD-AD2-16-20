package by.it.academy.newsnetworkmvvmexample.data.datasouce

import io.reactivex.Single

interface NewsDataSource {
    fun getTopHeadLines(country: String): Single<NewsInfoData>
}