package by.it.academy.newsnetworkmvvmexample.newslist

import androidx.annotation.DrawableRes

class NewsItem(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    @DrawableRes val errorImageId: Int
)