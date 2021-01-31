package by.it.academy.newsnetworkmvvmexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import by.it.academy.newsnetworkmvvmexample.newslist.ContactListFragment
import by.it.academy.newsnetworkmvvmexample.newsreader.NewsReaderFragment

class MainActivity : AppCompatActivity(), NewsNavigation {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        loadFragmentNewsList()
    }

    private fun loadFragmentNewsList() {
        supportFragmentManager.beginTransaction()
            .add<ContactListFragment>(R.id.fragmentContainer, ContactListFragment.TAG)
            .commit()
    }

    private fun loadFragmentNewsReader(url: String) {
        val bundle = NewsReaderFragment.newFragmentBundle(url)
        supportFragmentManager.beginTransaction()
            .add<NewsReaderFragment>(R.id.fragmentContainer, NewsReaderFragment.TAG, bundle)
            .addToBackStack(null)
            .commit()
    }

    override fun openNews(url: String) {
        loadFragmentNewsReader(url)
    }
}