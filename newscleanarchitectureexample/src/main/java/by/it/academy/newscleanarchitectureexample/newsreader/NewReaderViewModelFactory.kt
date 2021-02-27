package by.it.academy.newscleanarchitectureexample.newsreader

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class NewReaderViewModelFactory(
    private val url: String
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(NewsReaderViewModel::class.java)) {
            return NewsReaderViewModel(url) as T
        }
        throw IllegalArgumentException(
            "Unknown class fro the view model. Passed ${modelClass.canonicalName} " +
                    "but required NewsReaderViewModel"
        )
    }
}