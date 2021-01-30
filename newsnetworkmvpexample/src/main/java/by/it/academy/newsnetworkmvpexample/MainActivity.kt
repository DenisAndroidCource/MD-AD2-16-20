package by.it.academy.newsnetworkmvpexample

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.add
import by.it.academy.newsnetworkmvpexample.newslist.ContactListFragment

class MainActivity : AppCompatActivity() {
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
}