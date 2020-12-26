package by.it.academy.contentresolverexample

import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var userInfo: UserInfo? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val cursor = contentResolver.query(
            Uri.parse("content://by.it.academy.contentproviderexample/database/base_info"),
            null,
            null,
            arrayOf("1"),
            null
        )

        cursor?.run {
            cursor.moveToFirst()
            userInfo = UserInfo(
                id = cursor.getInt(cursor.getColumnIndex("id")),
                name = cursor.getString(cursor.getColumnIndex("name")),
                age = cursor.getInt(cursor.getColumnIndex("age")),
                address = cursor.getString(cursor.getColumnIndex("address"))
            )
            close()
        }
    }
}