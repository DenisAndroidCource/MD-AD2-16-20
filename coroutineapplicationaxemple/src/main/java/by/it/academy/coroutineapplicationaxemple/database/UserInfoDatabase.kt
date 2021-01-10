package by.it.academy.coroutineapplicationaxemple.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [UserInfo::class], version = 2, exportSchema = false)
abstract class UserInfoDatabase : RoomDatabase() {

    abstract fun getUserDao(): UserInfoDao

    companion object {
        private var DATABASE: UserInfoDatabase? = null

        fun getInstance(context: Context): UserInfoDatabase? {
            if (DATABASE == null) {
                DATABASE = Room.databaseBuilder(context, UserInfoDatabase::class.java, "db_user")
                    .addMigrations(AddDataMigration())
                    .build()
            }
            return DATABASE
        }
    }
}