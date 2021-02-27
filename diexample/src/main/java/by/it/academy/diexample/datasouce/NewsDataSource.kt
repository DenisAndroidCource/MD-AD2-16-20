package by.it.academy.diexample.datasouce

import io.reactivex.Single

interface NewsDataSource {
    fun getTopHeadLines(country: String): Single<NewsInfoDataModel>
}