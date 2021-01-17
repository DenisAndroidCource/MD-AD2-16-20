package by.it.academy.fragmentexample

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SharedDataViewModel: ViewModel() {

    private val valueMutableLiveData = MutableLiveData<String>()
    val valueLiveData: LiveData<String> = valueMutableLiveData

    fun postDataToAnotherScreen(data: String){
        valueMutableLiveData.value = data
    }
}