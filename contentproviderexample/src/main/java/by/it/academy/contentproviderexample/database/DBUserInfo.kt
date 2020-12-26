package by.it.academy.contentproviderexample.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserInfo::class], version = 1, exportSchema = false)
abstract class DBUserInfo: RoomDatabase() {

    abstract fun getUserInfoDao(): UserInfoDao

    companion object {
        private var database: DBUserInfo? = null

        fun getDatabase(context: Context): DBUserInfo {
            if (database == null) {
                database = Room.databaseBuilder(
                    context,
                    DBUserInfo::class.java,
                    "userinfo"
                ).build()
            }
            return database as DBUserInfo
        }
    }
}