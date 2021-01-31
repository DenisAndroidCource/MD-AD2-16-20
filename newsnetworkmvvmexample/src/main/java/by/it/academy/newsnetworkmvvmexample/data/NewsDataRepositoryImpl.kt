package by.it.academy.newsnetworkmvvmexample.data

import by.it.academy.newsnetworkmvvmexample.data.datasouce.ArticlesData
import by.it.academy.newsnetworkmvvmexample.data.datasouce.NewsDataSource
import by.it.academy.newsnetworkmvvmexample.data.datasouce.network.ApiController
import io.reactivex.Single

class NewsDataRepositoryImpl(
    private val newsDataSource: NewsDataSource = ApiController()
) : NewsDataRepository {

    override fun getTopHeadlines(country: String): Single<List<ArticlesData>> =
        newsDataSource.getTopHeadLines(country)
            .map { newsInfo -> newsInfo.articles }
}