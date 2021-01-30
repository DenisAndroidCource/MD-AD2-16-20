package by.it.academy.newsnetworkmvpexample.newslist

import by.it.academy.newsnetworkmvpexample.R
import by.it.academy.newsnetworkmvpexample.data.datasouce.ArticlesData

class NewsItemMapper : (List<ArticlesData>) -> List<NewsItem> {

    override fun invoke(newsDataList: List<ArticlesData>) =
        newsDataList.map { item ->
            NewsItem(
                title = item.title,
                description = item.description,
                url = item.url,
                urlToImage = item.urlToImage,
                errorImageId = R.drawable.ic_baseline_error_outline_24
            )
        }
}