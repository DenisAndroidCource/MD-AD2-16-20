package by.it.academy.preferencesexample

import android.content.Context
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var editText: EditText
    private lateinit var textView: TextView
    private lateinit var button: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        editText = findViewById(R.id.editText)
        textView = findViewById(R.id.textView)
        button = findViewById(R.id.button)
        readData()
        button.setOnClickListener {
            saveData()
        }
    }

    private fun saveData() {
        /** Java style*/
//        val sharePreference = getSharedPreferences("data", Context.MODE_PRIVATE)
//        val editor = sharePreference.edit()
//        editor.putString("editTEXTDATA", editText.text?.toString() ?: "")
//        editor.apply()
        /** Kotlin style*/
        getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
            .edit()
            .apply { putString(KEY_DATA, editText.text?.toString() ?: DEFAULT_TEXT) }
            .apply()
    }

    private fun readData() {
        val sharePreference = getSharedPreferences(FILE_NAME, Context.MODE_PRIVATE)
        val read = sharePreference.getString(KEY_DATA, DEFAULT_TEXT)
        editText.setText(read)
        textView.text = read
    }

    companion object {
        private const val FILE_NAME = "data"
        private const val KEY_DATA = "TEXT_DATA"
        private const val DEFAULT_TEXT = "DEFAULT"
    }
}