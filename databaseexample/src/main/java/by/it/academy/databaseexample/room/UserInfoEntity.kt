package by.it.academy.databaseexample.room

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
class UserInfoEntity(
    @PrimaryKey @ColumnInfo val id: Long,
    @ColumnInfo(name = "user_id") val userId: Long,
    @ColumnInfo val info: String
)