package by.it.academy.diexample.domain

import io.reactivex.Single

interface NewsTopHeadlinesUseCase {
    fun getTopHeadlines(): Single<List<ArticlesDomainModel>>
}