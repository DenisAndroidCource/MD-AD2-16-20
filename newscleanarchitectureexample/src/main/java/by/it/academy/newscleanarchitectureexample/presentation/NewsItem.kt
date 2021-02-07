package by.it.academy.newscleanarchitectureexample.presentation

import androidx.annotation.DrawableRes

class NewsItem(
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    @DrawableRes val errorImageId: Int
)