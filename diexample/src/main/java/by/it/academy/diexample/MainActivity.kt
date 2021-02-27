package by.it.academy.diexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.add
import by.it.academy.diexample.presentation.NewsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragmentNewsList()
    }

    private fun loadFragmentNewsList() {
        supportFragmentManager.beginTransaction()
            .add<NewsListFragment>(R.id.fragmentContainer, "NewsListFragment.TAG")
            .commit()
    }
}