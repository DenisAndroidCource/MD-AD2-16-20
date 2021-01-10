package by.it.academy.coroutineapplicationaxemple.database

import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase

class AddDataMigration: Migration(1, 2) {
    override fun migrate(database: SupportSQLiteDatabase) {
        database.execSQL("INSERT INTO userinfo (name, address) VALUES ('Denis', 'Minsk')")
        database.execSQL("INSERT INTO userinfo (name, address) VALUES ('Alex', 'Grodno')")
        database.execSQL("INSERT INTO userinfo (name, address) VALUES ('Dave', 'New York')")
        database.execSQL("INSERT INTO userinfo (name, address) VALUES ('Dima', 'Minsk')")
    }
}