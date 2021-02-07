package by.it.academy.newscleanarchitectureexample.datasouce

import io.reactivex.Single

interface NewsDataSource {
    fun getTopHeadLines(country: String): Single<NewsInfoDataModel>
}