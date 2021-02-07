package by.it.academy.newscleanarchitectureexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import by.it.academy.newscleanarchitectureexample.presentation.NewsListFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragmentNewsList()
    }

    private fun loadFragmentNewsList() {
        supportFragmentManager.beginTransaction()
            .add<NewsListFragment>(R.id.fragmentContainer, NewsListFragment.TAG)
            .commit()
    }
}