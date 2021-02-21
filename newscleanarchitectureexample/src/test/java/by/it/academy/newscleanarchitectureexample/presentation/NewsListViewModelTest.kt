package by.it.academy.newscleanarchitectureexample.presentation

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import by.it.academy.newscleanarchitectureexample.domain.ArticlesDomainModel
import by.it.academy.newscleanarchitectureexample.domain.NewsTopHeadlinesUseCase
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import io.mockk.verifyOrder
import io.reactivex.Single
import io.reactivex.disposables.CompositeDisposable
import org.junit.Assert.assertEquals
import org.junit.Rule
import org.junit.Test

private const val TITLE = "TITLE"
private const val DESCRIPTION = "DESCRIPTION"
private const val URL = "URL"
private const val URL_TO_IMAGE = "URL_TO_IMAGE"
private const val EMPTY_STRING = ""

class NewsListViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    //    private val compositeDisposableMock = mock(CompositeDisposable::class.java)
    private val compositeDisposableMock = mockk<CompositeDisposable>(relaxed = true)
    private val newsTopHeadlinesUseCaseMock = mockk<NewsTopHeadlinesUseCase>(relaxed = true)
    private val mapperMock = mockk<(List<ArticlesDomainModel>) -> List<NewsItem>>(relaxed = true)
    private val articlesDomainModelMock = mockk<ArticlesDomainModel>(relaxed = true)
    private val newsItemMock = mockk<NewsItem>(relaxed = true)

    private val viewModel = NewsListViewModel(
        compositeDisposable = compositeDisposableMock,
        newsTopHeadlinesUseCase = newsTopHeadlinesUseCaseMock,
        mapper = mapperMock
    )

    @Test
    fun `when fetching data then all components invoked`() {
//        `when`(newsTopHeadlinesUseCaseMock.getTopHeadlines()).thenReturn(Single.just(listOf(articlesDomainModelMock))
        val domainModelList = listOf(articlesDomainModelMock)
        every { newsTopHeadlinesUseCaseMock.getTopHeadlines() } returns Single.just(domainModelList)
        every { mapperMock.invoke(domainModelList) } returns listOf(newsItemMock)

        viewModel.fetchNewsList()

//        verify(newsTopHeadlinesUseCaseMock).getTopHeadlines()
        verifyOrder {
            newsTopHeadlinesUseCaseMock.getTopHeadlines()
            mapperMock.invoke(domainModelList)
            compositeDisposableMock.add(any())
        }
    }

    @Test
    fun `when fetching data failed then not all components invoked`() {
        val domainModelList = listOf(articlesDomainModelMock)
        every { newsTopHeadlinesUseCaseMock.getTopHeadlines() } returns Single.error(Throwable())
        every { mapperMock.invoke(domainModelList) } returns listOf(newsItemMock)

        viewModel.fetchNewsList()

        verify {
            newsTopHeadlinesUseCaseMock.getTopHeadlines()
            compositeDisposableMock.add(any())
        }

        verify(exactly = 0) { mapperMock.invoke(domainModelList) }
    }

    @Test
    fun `when fetching data finished then live data contains result`() {
        val domainModelList = listOf(articlesDomainModelMock)
        val newsItemList = listOf(newsItemMock)
        every { newsTopHeadlinesUseCaseMock.getTopHeadlines() } returns Single.just(domainModelList)
        every { mapperMock.invoke(any()) } returns newsItemList

        viewModel.fetchNewsList()

        assertEquals(newsItemList, viewModel.newsLiveData.value)
    }
}