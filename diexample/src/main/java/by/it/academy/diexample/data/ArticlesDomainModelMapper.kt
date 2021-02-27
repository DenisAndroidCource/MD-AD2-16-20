package by.it.academy.diexample.data

import by.it.academy.diexample.datasouce.ArticlesDataModel
import by.it.academy.diexample.domain.ArticlesDomainModel

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