package by.it.academy.newsnetworkmvvmexample.newslist

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.it.academy.newsnetworkmvvmexample.data.NewsDataRepository
import by.it.academy.newsnetworkmvvmexample.data.datasouce.ArticlesData
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

class NewsListViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val newsDataRepository: NewsDataRepository,
    private val mapper: (List<ArticlesData>) -> List<NewsItem>
) : ViewModel() {

    private val mutableNewsLiveData = MutableLiveData<List<NewsItem>>()
    val newsLiveData: LiveData<List<NewsItem>> = mutableNewsLiveData

    private val mutableNewsErrorLiveData = MutableLiveData<String>()
    val newsErrorLiveData: LiveData<String> = mutableNewsErrorLiveData

    fun fetchNewsList() {
        newsDataRepository.getTopHeadlines("us")
            .map { newsDataList -> mapper(newsDataList) }
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(
                { newsList -> mutableNewsLiveData.value = newsList },
                { error ->
                    Log.d("ERR", error.toString())
                    mutableNewsErrorLiveData.value = "Error"
                }
            ).also { compositeDisposable.add(it) }
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.clear()
    }
}