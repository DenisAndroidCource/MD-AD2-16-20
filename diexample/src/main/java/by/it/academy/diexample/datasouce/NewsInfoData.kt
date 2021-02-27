package by.it.academy.diexample.datasouce

data class NewsInfoDataModel(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesDataModel>
)

data class ArticlesDataModel(
    val source: SourceDataModel,
    val author: String,
    val title: String,
    val description: String?,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class SourceDataModel(
    val id: String?,
    val name: String
)