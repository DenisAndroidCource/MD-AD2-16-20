package by.it.academy.filesexample

import android.media.MediaPlayer
import android.os.Bundle
import android.os.Environment
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import java.io.File

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        button = findViewById<Button>(R.id.button).apply {
            setOnClickListener { saveToFile(editText.text?.toString() ?: "") }
        }
    }

    private fun saveToFile(message: String) {
        File(filesDir, "text.txt").writeText(message)
    }

    private fun isExternalStorageExists() =
        Environment.getExternalStorageState() == Environment.MEDIA_MOUNTED

    private fun writeToExternal(){
        val file = getExternalFilesDir(Environment.DIRECTORY_DCIM)
    }
}