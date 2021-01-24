package by.it.academy.mvpexample

interface MainActivityView {
    fun showData(data: DataToShow)
}

interface MainActivityPresenter {
    fun fetchData()
    fun close()
}