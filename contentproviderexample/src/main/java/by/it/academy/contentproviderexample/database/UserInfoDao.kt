package by.it.academy.contentproviderexample.database

import android.database.Cursor
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface UserInfoDao {

    @Query("SELECT * FROM user_info")
    fun getAllInfo(): Cursor?

    @Query("SELECT * FROM user_info WHERE id = :id")
    fun getInfo(id: Long): Cursor?

    @Insert
    fun insert(userInfo: UserInfo): Int

    @Update
    fun update(userInfo: UserInfo): Int
}