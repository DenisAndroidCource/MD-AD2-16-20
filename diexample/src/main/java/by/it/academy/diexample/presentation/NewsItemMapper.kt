package by.it.academy.diexample.presentation

import by.it.academy.diexample.R
import by.it.academy.diexample.domain.ArticlesDomainModel

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