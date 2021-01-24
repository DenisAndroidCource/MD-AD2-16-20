package by.it.academy.retrofitexample

import kotlinx.serialization.Serializable

//import com.google.gson.annotations.SerializedName

//@Serializable
data class NewsRootObject(
    val status: String,
    val totalResults: Int,
    val articles: List<Articles>
)

//@Serializable
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

//@Serializable
data class Source(
    val id: String?,
    val name: String
)