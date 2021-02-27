package by.it.academy.newscleanarchitectureexample.newsreader

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.browser.customtabs.CustomTabsIntent
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import by.it.academy.newscleanarchitectureexample.R
import by.it.academy.newscleanarchitectureexample.databinding.FragmentNewsReaderBinding

class NewsReaderFragment : Fragment(R.layout.fragment_news_reader) {

    private lateinit var binding: FragmentNewsReaderBinding
    private lateinit var viewModel: NewsReaderViewModel

    private val urlArgs: String
        get() = requireArguments().getString(BUNDLE_URL_KEY) ?: ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentNewsReaderBinding.bind(view)

        viewModel = ViewModelProvider(this, NewReaderViewModelFactory(urlArgs))
            .get(NewsReaderViewModel::class.java)
            .also {
                it.newsUrlLiveData.observe(
                    viewLifecycleOwner,
                    Observer { url -> openUrlInTabs(url) })
            }
        binding.webView.loadUrl(urlArgs)
    }

    private fun openUrlInTabs(url: Uri) {
//        context?.run {
//            CustomTabsIntent.Builder()
//                .setShowTitle(true)
//                .build()
//                .launchUrl(this, url)
//        }
    }

    companion object {
        const val TAG = "NewsReaderFragment"
        private const val BUNDLE_URL_KEY = "BUNGLE_URL_KEY"

        @JvmStatic
        fun newFragmentBundle(url: String) = bundleOf(BUNDLE_URL_KEY to url)
    }
}