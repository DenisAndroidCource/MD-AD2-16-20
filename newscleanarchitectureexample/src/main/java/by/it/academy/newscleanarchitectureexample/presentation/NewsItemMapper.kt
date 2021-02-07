package by.it.academy.newscleanarchitectureexample.presentation

import by.it.academy.newscleanarchitectureexample.R
import by.it.academy.newscleanarchitectureexample.domain.ArticlesDomainModel

class NewsItemMapper : (List<ArticlesDomainModel>) -> List<NewsItem> {

    override fun invoke(newsDataList: List<ArticlesDomainModel>) =
        newsDataList.map { item ->
            NewsItem(
                title = item.title,
                description = item.description ?: "",
                url = item.url,
                urlToImage = item.urlToImage,
                errorImageId = R.drawable.ic_baseline_error_outline_24
            )
        }
}