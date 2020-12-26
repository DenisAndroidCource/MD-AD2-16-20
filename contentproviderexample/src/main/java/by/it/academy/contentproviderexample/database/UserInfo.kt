package by.it.academy.contentproviderexample.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "user_info")
class UserInfo(
    @PrimaryKey(autoGenerate = true) @ColumnInfo private val id: Int = 0,
    @ColumnInfo val name: String,
    @ColumnInfo val age: Int,
    @ColumnInfo val address: String
)