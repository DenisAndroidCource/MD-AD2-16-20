package by.it.academy.mvpexample

import by.it.academy.mvpexample.database.Database
import by.it.academy.mvpexample.database.DatabaseImpl

class DataToShow(val data: String)

class MainActivityPresenterImpl(
    private var view: MainActivityView?,
    private val database: Database = DatabaseImpl()
): MainActivityPresenter {

    override fun fetchData() {
        val data = database.getData()
        view?.showData(DataToShow(data))
    }

    override fun close() {
        view = null
    }
}