package by.it.academy.rxjavaapplicationexample.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserInfoDao {
    @Query("SELECT * FROM userinfo")
    fun getAllInfo(): List<UserInfo>

    @Insert
    fun insert(userInfo: UserInfo)
}