package by.it.academy.newscleanarchitectureexample.presentation

import android.content.Context
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.it.academy.newscleanarchitectureexample.R
import by.it.academy.newscleanarchitectureexample.databinding.FragmentContactListBinding
import com.google.android.material.snackbar.Snackbar

class NewsListFragment : Fragment(R.layout.fragment_contact_list) {

    private lateinit var binding: FragmentContactListBinding
    private val newsListAdapter by lazy {
//        NewsListItemsAdapter { url -> newsNavigation?.openNews(url) }
        NewsListItemsAdapter { }
    }
    private var snackbar: Snackbar? = null

    private lateinit var viewModel: NewsListViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)
//        if (context is NewsNavigation) {
//            newsNavigation = context
//        }
    }

    override fun onDetach() {
//        newsNavigation = null
        super.onDetach()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactListBinding.bind(view)
        binding.newsList.apply {
            adapter = newsListAdapter
            layoutManager = LinearLayoutManager(context)
        }

        viewModel = ViewModelProvider(this, NewsListViewModelFactory())
            .get(NewsListViewModel::class.java)
            .also {
                it.newsLiveData.observe(viewLifecycleOwner, Observer { data -> showNewsList(data) })
                it.newsErrorLiveData.observe(viewLifecycleOwner, Observer { err -> showError(err) })
                it.fetchNewsList()
            }
    }

    private fun showNewsList(list: List<NewsItem>) {
        snackbar?.dismiss()
        newsListAdapter.items = list
    }

    private fun showError(errorMessage: String) {
        snackbar = Snackbar.make(binding.root, errorMessage, Snackbar.LENGTH_INDEFINITE)
            .also { it.show() }
    }

    companion object {
        const val TAG = "ContactListFragment"
    }
}