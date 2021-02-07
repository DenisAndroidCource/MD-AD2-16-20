package by.it.academy.newscleanarchitectureexample.data

import by.it.academy.newscleanarchitectureexample.domain.ArticlesDomainModel
import io.reactivex.Single

interface NewsDataRepository {
    fun getTopHeadlines(country: String): Single<List<ArticlesDomainModel>>
}