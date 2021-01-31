package by.it.academy.newsnetworkmvvmexample.data

import by.it.academy.newsnetworkmvvmexample.data.datasouce.ArticlesData
import io.reactivex.Single

interface NewsDataRepository {
    fun getTopHeadlines(country: String): Single<List<ArticlesData>>
}