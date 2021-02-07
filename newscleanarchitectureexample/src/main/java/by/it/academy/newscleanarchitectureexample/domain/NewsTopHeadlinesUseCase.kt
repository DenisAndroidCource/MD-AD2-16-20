package by.it.academy.newscleanarchitectureexample.domain

import io.reactivex.Single

interface NewsTopHeadlinesUseCase {
    fun getTopHeadlines(): Single<List<ArticlesDomainModel>>
}