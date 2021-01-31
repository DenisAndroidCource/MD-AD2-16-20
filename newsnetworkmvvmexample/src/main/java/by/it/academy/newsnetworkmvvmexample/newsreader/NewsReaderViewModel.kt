package by.it.academy.newsnetworkmvvmexample.newsreader

import android.net.Uri
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class NewsReaderViewModel(url: String) : ViewModel() {
    private val newsUrlMutableLiveData = MutableLiveData<Uri>(Uri.parse(url))
    val newsUrlLiveData: LiveData<Uri> = newsUrlMutableLiveData
}