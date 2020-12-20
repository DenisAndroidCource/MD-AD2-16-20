package by.it.academy.databaseexample

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import by.it.academy.databaseexample.room.DatabaseInfo

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = DatabaseInfo.init(this).getUserInfoDAO()
        val infiList = dao.getAllInfo()
    }

    private fun getData(str: String) {
        val database = DBHelper(this).writableDatabase
        val cursor: Cursor? = database.query(
            "info",
            arrayOf("user_id, info"),
            "info=? AND user_id=?",
            arrayOf("skype", "1"),
            null,
            null,
            "DESC"
        )

        if (cursor != null) {
            val infoList = mutableListOf<String>()
            val infoIndex = cursor.getColumnIndex("info")
            while (cursor.moveToNext()) {
                val info = cursor.getString(infoIndex)
                infoList.add(info)
            }
            cursor.close()
        }
    }
}