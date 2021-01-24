package by.it.academy.newsnetworkmvpexample.newslist

import by.it.academy.newsnetworkmvpexample.data.datasouce.ArticlesData

interface NewsListPresenter {
    fun fetchNewsList()
}

interface NewsListView {
    fun showNewsList(list: List<ArticlesData>)
    fun showError(errorMessage: String)
}