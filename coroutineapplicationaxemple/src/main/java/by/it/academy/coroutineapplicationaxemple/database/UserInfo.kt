package by.it.academy.coroutineapplicationaxemple.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "userinfo")
class UserInfo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo val id: Long,
    @ColumnInfo val name: String,
    @ColumnInfo val address: String
)