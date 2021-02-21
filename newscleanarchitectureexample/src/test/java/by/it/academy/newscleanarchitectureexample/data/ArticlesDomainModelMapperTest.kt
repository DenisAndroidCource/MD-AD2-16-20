package by.it.academy.newscleanarchitectureexample.data

import by.it.academy.newscleanarchitectureexample.datasouce.ArticlesDataModel
import by.it.academy.newscleanarchitectureexample.datasouce.SourceDataModel
import org.junit.Assert.assertEquals
import org.junit.Test

private const val TITLE = "TITLE"
private const val DESCRIPTION = "DESCRIPTION"
private const val URL = "URL"
private const val URL_TO_IMAGE = "URL_TO_IMAGE"
private const val EMPTY_STRING = ""

class ArticlesDomainModelMapperTest {

    private val mapper = ArticlesDomainModelMapper()

    private val dataModel = ArticlesDataModel(
        source = SourceDataModel(null, EMPTY_STRING),
        author = EMPTY_STRING,
        title = TITLE,
        description = DESCRIPTION,
        urlToImage = URL_TO_IMAGE,
        url = URL,
        publishedAt = EMPTY_STRING,
        content = EMPTY_STRING
    )

    @Test
    fun `when list contains items then the result has the same size`() {
        val dataModelList = listOf(dataModel, dataModel, dataModel, dataModel)
        val resultList = mapper(dataModelList)

        assertEquals(dataModelList.size, resultList.size)
    }

    @Test
    fun `when list contains the data then it should be mapped`() {
        val resultList = mapper(listOf(dataModel))

        with(resultList[0]) {
            assertEquals(TITLE, title)
            assertEquals(DESCRIPTION, description)
            assertEquals(URL, url)
            assertEquals(URL_TO_IMAGE, urlToImage)
        }
    }
}