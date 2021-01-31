package by.it.academy.newsnetworkmvvmexample.newslist

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import by.it.academy.newsnetworkmvvmexample.data.NewsDataRepositoryImpl
import io.reactivex.disposables.CompositeDisposable

class NewsListViewModelFactory : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsListViewModel::class.java)) {
            return NewsListViewModel(
                compositeDisposable = CompositeDisposable(),
                newsDataRepository = NewsDataRepositoryImpl(),
                mapper = NewsItemMapper()
            ) as T
        }
        throw IllegalArgumentException(
            "Unknown class fro the view model. Passed ${modelClass.canonicalName} " +
                    "but required NewsListViewModel"
        )
    }
}