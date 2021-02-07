package by.it.academy.newscleanarchitectureexample.data

import by.it.academy.newscleanarchitectureexample.datasouce.ArticlesDataModel
import by.it.academy.newscleanarchitectureexample.domain.ArticlesDomainModel

class ArticlesDomainModelMapper : (List<ArticlesDataModel>) -> List<ArticlesDomainModel> {

    override fun invoke(dataModelList: List<ArticlesDataModel>) =
        dataModelList.map { item ->
            ArticlesDomainModel(
                title = item.title,
                description = item.description,
                url = item.url,
                urlToImage = item.urlToImage
            )
        }
}