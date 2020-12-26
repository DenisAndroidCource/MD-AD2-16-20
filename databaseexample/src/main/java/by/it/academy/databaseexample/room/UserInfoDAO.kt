package by.it.academy.databaseexample.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface UserInfoDAO {

    @Query("SELECT * FROM user_info")
    fun getAllInfo(): List<UserInfoEntity>

    @Query("SELECT * FROM user_info WHERE id = :infoId")
    fun getInfo(infoId: Long): UserInfoEntity

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun add(entity: UserInfoEntity)
}