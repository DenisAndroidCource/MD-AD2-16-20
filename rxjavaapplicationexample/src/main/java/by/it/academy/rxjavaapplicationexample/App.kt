package by.it.academy.rxjavaapplicationexample

import android.app.Application
import by.it.academy.rxjavaapplicationexample.database.UserInfoDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        UserInfoDatabase.getInstance(this)
    }
}