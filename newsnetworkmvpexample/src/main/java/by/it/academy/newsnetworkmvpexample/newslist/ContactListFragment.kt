package by.it.academy.newsnetworkmvpexample.newslist

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import by.it.academy.newsnetworkmvpexample.R
import by.it.academy.newsnetworkmvpexample.databinding.FragmentContactListBinding
import com.google.android.material.snackbar.Snackbar

class ContactListFragment : Fragment(R.layout.fragment_contact_list), NewsListView {

    private val presenter: NewsListPresenter = NewsListPresenterImpl(newsListView = this)
    private lateinit var binding: FragmentContactListBinding
    private val newsListAdapter by lazy { NewsListItemsAdapter() }
    private var snackbar: Snackbar? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactListBinding.bind(view)

        binding.newsList.apply {
            adapter = newsListAdapter
            layoutManager = LinearLayoutManager(context)
        }
    }

    override fun showNewsList(list: List<NewsItem>) {
        snackbar?.dismiss()
        newsListAdapter.items = list
    }

    override fun showError(errorMessage: String) {
        snackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
            .also { it.show() }
    }

    override fun onResume() {
        super.onResume()
        presenter.fetchNewsList()
    }

    override fun onStop() {
        super.onStop()
        presenter.close()
    }

    companion object {
        const val TAG = "ContactListFragment"
    }
}