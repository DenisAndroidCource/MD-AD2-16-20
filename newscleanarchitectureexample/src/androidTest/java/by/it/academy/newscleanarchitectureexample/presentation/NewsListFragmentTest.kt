package by.it.academy.newscleanarchitectureexample.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.fragment.app.testing.launchFragmentInContainer
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.espresso.matcher.ViewMatchers.withText
import by.it.academy.newscleanarchitectureexample.R
import by.it.academy.newscleanarchitectureexample.RecyclerViewMatcher
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.Rule
import org.junit.Test

private const val TITLE = "TITLE"
private const val DESCRIPTION = "DESCRIPTION"
private const val URL = "URL"
private const val URL_TO_IMAGE = "URL_TO_IMAGE"

class NewsListFragmentTest {

    @get:Rule
    var instantExecutorRule = InstantTaskExecutorRule()

    private val newsItem by lazy {
        NewsItem(
            title = TITLE,
            description = DESCRIPTION,
            url = URL,
            urlToImage = URL_TO_IMAGE,
            errorImageId = R.drawable.ic_baseline_error_outline_24
        )
    }
    private val newsMutableLiveData = MutableLiveData<List<NewsItem>>()
    private val viewModelMock = mockk<NewsListViewModel>(relaxed = true) {
        every { newsLiveData } returns newsMutableLiveData
    }

    @Test
    fun whenDataReceivedThenTheListDisplayed() {
        newsMutableLiveData.postValue(listOf(newsItem))

        launchFragment()

        onView(withId(R.id.button)).check(matches(isDisplayed()))
        onView(withText("TEXT")).check(matches(isDisplayed()))

        onView(RecyclerViewMatcher(R.id.newsList).atPositionOnView(0, R.id.textTitle))
            .check(matches(withText(TITLE)))
    }

    @Test
    fun whenButtonClickedThenViewModelInvoked() {
        launchFragment()
        onView(withId(R.id.button)).perform(click())

        verify {
            viewModelMock.fetchNewsList()
        }
    }

    private fun launchFragment() {
        launchFragmentInContainer {
            NewsListFragment().apply {
                viewModelFactory = object : ViewModelProvider.Factory {
                    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                        viewModelMock as T
                }
            }
        }
    }
}