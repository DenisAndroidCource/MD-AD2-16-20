package by.it.academy.diexample.data

import by.it.academy.diexample.domain.ArticlesDomainModel
import io.reactivex.Single

interface NewsDataRepository {
    fun getTopHeadlines(country: String): Single<List<ArticlesDomainModel>>
}