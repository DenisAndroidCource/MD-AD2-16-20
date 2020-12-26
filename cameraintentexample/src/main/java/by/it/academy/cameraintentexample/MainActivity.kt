package by.it.academy.cameraintentexample

import android.content.Intent
import android.graphics.BitmapFactory
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import android.widget.Button
import java.io.File

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById<Button>(R.id.startCamera).setOnClickListener { takePhoto() }
    }

    private fun takePhoto() {
        val fileTemp = File(getExternalFilesDir(Environment.DIRECTORY_PICTURES), "PhotoTemp.jpg")
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        intent.putExtra(MediaStore.EXTRA_OUTPUT, fileTemp)
        startActivityForResult(intent, 1000)
    }
}