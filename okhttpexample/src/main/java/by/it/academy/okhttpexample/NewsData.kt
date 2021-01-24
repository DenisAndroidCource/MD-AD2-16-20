package by.it.academy.okhttpexample

//import kotlinx.serialization.Serializable

//import com.google.gson.annotations.SerializedName

data class NewsRootObject(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
)

data class Articles(
    val source: Source,
    val author: String,
    val title: String,
    val description: String,
    val url: String,
    val urlToImage: String?,
//    @SerializedName("urlToImage") val urlToImage: String?,
    val publishedAt: String,
    val content: String
)

data class Source(
    val id: String?,
    val name: String
)