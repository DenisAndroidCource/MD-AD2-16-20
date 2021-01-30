package by.it.academy.newsnetworkmvpexample.newslist

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import by.it.academy.newsnetworkmvpexample.data.datasouce.ArticlesData

interface NewsListPresenter {
    fun fetchNewsList()
    fun close()
}

interface NewsListView {
    fun showNewsList(list: List<NewsItem>)
    fun showError(errorMessage: String)
}

class NewsItem(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    @DrawableRes val errorImageId: Int
)