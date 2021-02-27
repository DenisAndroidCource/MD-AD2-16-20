package by.it.academy.diexample.presentation

import android.util.Log
import androidx.annotation.VisibleForTesting
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import by.it.academy.diexample.domain.ArticlesDomainModel
import by.it.academy.diexample.domain.NewsTopHeadlinesUseCase
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable

@VisibleForTesting
class NewsListViewModel(
    private val compositeDisposable: CompositeDisposable,
    private val newsTopHeadlinesUseCase: NewsTopHeadlinesUseCase,
    private val mapper: (List<ArticlesDomainModel>) -> List<NewsItem>
) : ViewModel() {

    private val mutableNewsLiveData = MutableLiveData<List<NewsItem>>()
    val newsLiveData: LiveData<List<NewsItem>> = mutableNewsLiveData

    private val mutableNewsErrorLiveData = MutableLiveData<String>()
    val newsErrorLiveData: LiveData<String> = mutableNewsErrorLiveData

    fun fetchNewsList() {
        newsTopHeadlinesUseCase.getTopHeadlines()
            .map { newsDomainList -> mapper(newsDomainList) }
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