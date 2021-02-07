package by.it.academy.newscleanarchitectureexample.domain

import by.it.academy.newscleanarchitectureexample.data.NewsDataRepository
import by.it.academy.newscleanarchitectureexample.data.NewsDataRepositoryImpl
import io.reactivex.Single

class NewsTopHeadlinesUseCaseImpl(
    private val newsDataRepository: NewsDataRepository = NewsDataRepositoryImpl()
) : NewsTopHeadlinesUseCase {
    override fun getTopHeadlines(): Single<List<ArticlesDomainModel>> =
        newsDataRepository.getTopHeadlines("US")
            .map { domainModelList ->
                domainModelList.filter { item ->
                    !item.title.contains(" war ", true)
                }
            }
}