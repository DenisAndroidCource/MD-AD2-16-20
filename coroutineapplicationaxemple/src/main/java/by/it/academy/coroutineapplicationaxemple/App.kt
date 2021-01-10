package by.it.academy.coroutineapplicationaxemple

import android.app.Application
import by.it.academy.coroutineapplicationaxemple.database.UserInfoDatabase

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        UserInfoDatabase.getInstance(this)
    }
}