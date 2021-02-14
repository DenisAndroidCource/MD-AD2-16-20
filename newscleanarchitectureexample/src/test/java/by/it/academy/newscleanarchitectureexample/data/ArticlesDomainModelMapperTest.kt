package by.it.academy.newscleanarchitectureexample.data

import by.it.academy.newscleanarchitectureexample.datasouce.ArticlesDataModel
import by.it.academy.newscleanarchitectureexample.datasouce.SourceDataModel
import org.junit.Assert.assertEquals
import org.junit.Test

class ArticlesDomainModelMapperTest {

    private val mapper = ArticlesDomainModelMapper()

    @Test
    fun `when listContains items then the result has the same size`() {
        val sourceModel = SourceDataModel(null, "")
        val dataModel = ArticlesDataModel(
            source = sourceModel,
            author = "",
            title = "",
            description = null,
            urlToImage = "",
            url = "",
            publishedAt = "",
            content = ""
        )

        val dataModelList = listOf(dataModel, dataModel, dataModel, dataModel)
        val resultList = mapper(dataModelList)

        assertEquals(dataModelList.size, resultList.size)
    }
}