package by.it.academy.newscleanarchitectureexample

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import by.it.academy.newscleanarchitectureexample.newsreader.NewsReaderFragment
import by.it.academy.newscleanarchitectureexample.presentation.NewsListFragment

class MainActivity : AppCompatActivity(), NewsNavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            loadFragmentNewsList()
        }

        Log.d("BUG", "Fragment size - ${supportFragmentManager.fragments.size}")
        Log.d("BUG", supportFragmentManager.fragments.toString())
    }

    private fun loadFragmentNewsList() {
        supportFragmentManager.beginTransaction()
            .setReorderingAllowed(true)
            .add<NewsListFragment>(R.id.fragmentContainer, NewsListFragment.TAG)
            .commit()
    }

    override fun openNews(url: String) {
        val bundle = NewsReaderFragment.newFragmentBundle(url)
        supportFragmentManager.beginTransaction()
            .add<NewsReaderFragment>(R.id.fragmentContainer, NewsReaderFragment.TAG, bundle)
            .addToBackStack(null)
            .commit()
    }
}