package by.it.academy.newsnetworkmvvmexample.newslist

import by.it.academy.newsnetworkmvvmexample.R
import by.it.academy.newsnetworkmvvmexample.data.datasouce.ArticlesData

class NewsItemMapper : (List<ArticlesData>) -> List<NewsItem> {

    override fun invoke(newsDataList: List<ArticlesData>) =
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