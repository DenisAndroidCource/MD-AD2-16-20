package by.it.academy.newscleanarchitectureexample.data

import by.it.academy.newscleanarchitectureexample.datasouce.ArticlesDataModel
import by.it.academy.newscleanarchitectureexample.datasouce.NewsDataSource
import by.it.academy.newscleanarchitectureexample.datasouce.network.ApiController
import by.it.academy.newscleanarchitectureexample.domain.ArticlesDomainModel
import io.reactivex.Single

class NewsDataRepositoryImpl(
    private val newsDataSource: NewsDataSource = ApiController(),
    private val mapper: (List<ArticlesDataModel>) -> List<ArticlesDomainModel> = ArticlesDomainModelMapper()
) : NewsDataRepository {

    override fun getTopHeadlines(country: String): Single<List<ArticlesDomainModel>> =
        newsDataSource.getTopHeadLines(country)
            .map { dataModel -> mapper(dataModel.articles) }
}