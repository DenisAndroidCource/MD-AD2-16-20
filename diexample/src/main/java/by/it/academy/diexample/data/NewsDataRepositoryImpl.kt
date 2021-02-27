package by.it.academy.diexample.data

import by.it.academy.diexample.datasouce.ArticlesDataModel
import by.it.academy.diexample.datasouce.NewsDataSource
import by.it.academy.diexample.domain.ArticlesDomainModel
import io.reactivex.Single

class NewsDataRepositoryImpl(
    private val newsDataSource: NewsDataSource,
    private val mapper: (List<ArticlesDataModel>) -> List<ArticlesDomainModel>
) : NewsDataRepository {

    override fun getTopHeadlines(country: String): Single<List<ArticlesDomainModel>> =
        newsDataSource.getTopHeadLines(country)
            .map { dataModel -> mapper(dataModel.articles) }
}