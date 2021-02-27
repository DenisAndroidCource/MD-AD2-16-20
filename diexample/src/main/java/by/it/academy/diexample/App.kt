package by.it.academy.diexample

import android.app.Application
import by.it.academy.diexample.di.dataSourceModule
import by.it.academy.diexample.di.mapperModule
import by.it.academy.diexample.di.repoModule
import by.it.academy.diexample.di.rxModule
import by.it.academy.diexample.di.useCaseModule
import by.it.academy.diexample.di.viewModelModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class App : Application(){

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(viewModelModule, rxModule, useCaseModule, repoModule, dataSourceModule, mapperModule)
        }
    }
}