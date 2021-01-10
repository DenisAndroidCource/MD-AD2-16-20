package by.it.academy.coroutineapplicationaxemple.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

@Dao
interface UserInfoDao {
    @Query("SELECT * FROM userinfo")
    suspend fun getAllInfo(): List<UserInfo>

    @Insert
    suspend fun insert(userInfo: UserInfo)
}