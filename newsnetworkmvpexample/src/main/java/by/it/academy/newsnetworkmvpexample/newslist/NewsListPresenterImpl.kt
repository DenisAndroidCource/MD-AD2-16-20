package by.it.academy.newsnetworkmvpexample.newslist

import by.it.academy.newsnetworkmvpexample.data.NewsDataRepository
import by.it.academy.newsnetworkmvpexample.data.NewsDataRepositoryImpl
import io.reactivex.Completable

class NewsListPresenterImpl(
    private val newsListView: NewsListView,
    private val newsDataRepository: NewsDataRepository = NewsDataRepositoryImpl()
) : NewsListPresenter {
    override fun fetchNewsList() {
        newsDataRepository.getTopHeadlines("us")
//            .observeOn()
            .subscribe(
                { newsList -> newsListView.showNewsList(newsList) },
                { newsListView.showError("Error!") }
            )
    }
}