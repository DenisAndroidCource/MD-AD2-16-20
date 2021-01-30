package by.it.academy.newsnetworkmvpexample.newslist

import android.util.Log
import by.it.academy.newsnetworkmvpexample.data.NewsDataRepository
import by.it.academy.newsnetworkmvpexample.data.NewsDataRepositoryImpl
import by.it.academy.newsnetworkmvpexample.data.datasouce.ArticlesData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class NewsListPresenterImpl(
    private val compositeDisposable: CompositeDisposable = CompositeDisposable(),
    private val newsListView: NewsListView,
    private val newsDataRepository: NewsDataRepository = NewsDataRepositoryImpl(),
    private val mapper: (List<ArticlesData>) -> List<NewsItem> = NewsItemMapper()
) : NewsListPresenter {

    override fun fetchNewsList() {
        newsDataRepository.getTopHeadlines("us")
            .map { newsDataList -> mapper(newsDataList) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { newsList -> newsListView.showNewsList(newsList) },
                { error ->
                    newsListView.showError("Error!")
                    Log.d("ERROR_NEWS", error.toString())
                }
            ).also { compositeDisposable.add(it) }
    }

    override fun close() {
        compositeDisposable.clear()
    }
}