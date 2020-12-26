package by.it.academy.databaseexample.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserInfoEntity::class], version = 1, exportSchema = false)
abstract class DatabaseInfo: RoomDatabase() {

    abstract fun getUserInfoDAO(): UserInfoDAO

    companion object {
        fun init(context: Context) =
            Room.databaseBuilder(context, DatabaseInfo::class.java, "database")
                .allowMainThreadQueries()
                .build()
    }
}