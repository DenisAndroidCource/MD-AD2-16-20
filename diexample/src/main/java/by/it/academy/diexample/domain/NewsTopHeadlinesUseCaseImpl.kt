package by.it.academy.diexample.domain

import by.it.academy.diexample.data.NewsDataRepository
import io.reactivex.Single

class NewsTopHeadlinesUseCaseImpl(
    private val newsDataRepository: NewsDataRepository
) : NewsTopHeadlinesUseCase {
    override fun getTopHeadlines(): Single<List<ArticlesDomainModel>> =
        newsDataRepository.getTopHeadlines("US")
            .map { domainModelList ->
                domainModelList.filter { item ->
                    !item.title.contains(" war ", true)
                }
            }
}