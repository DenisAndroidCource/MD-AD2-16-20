package by.it.academy.diexample.presentation

import android.os.Bundle
import android.view.View
import androidx.annotation.VisibleForTesting
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import by.it.academy.diexample.R
import by.it.academy.diexample.databinding.FragmentContactListBinding
import com.google.android.material.snackbar.Snackbar
import org.koin.android.viewmodel.ext.android.viewModel

class NewsListFragment : Fragment(R.layout.fragment_contact_list) {

    private lateinit var binding: FragmentContactListBinding
    private val newsListAdapter by lazy {
        NewsListItemsAdapter { }
    }
    private var snackbar: Snackbar? = null

    val viewModel: NewsListViewModel by viewModel()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentContactListBinding.bind(view)
        binding.newsList.apply {
            adapter = newsListAdapter
            layoutManager = LinearLayoutManager(context)
        }
        with(viewModel) {
            newsLiveData.observe(viewLifecycleOwner, Observer { data -> showNewsList(data) })
            newsErrorLiveData.observe(viewLifecycleOwner, Observer { err -> showError(err) })
            fetchNewsList()
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
}