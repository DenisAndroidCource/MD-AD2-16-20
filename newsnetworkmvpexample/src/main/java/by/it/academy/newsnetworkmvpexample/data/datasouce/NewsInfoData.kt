package by.it.academy.newsnetworkmvpexample.data.datasouce

data class NewsInfoData(
    val status: String,
    val totalResults: Int,
    val articles: List<ArticlesData>
)

data class ArticlesData(
    val source: SourceData,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class SourceData(
    val id: String?,
    val name: String
)