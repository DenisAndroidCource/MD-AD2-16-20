package by.it.academy.newsnetworkmvpexample.data

import by.it.academy.newsnetworkmvpexample.data.datasouce.ArticlesData
import io.reactivex.Single

interface NewsDataRepository {
    fun getTopHeadlines(country: String): Single<List<ArticlesData>>
}