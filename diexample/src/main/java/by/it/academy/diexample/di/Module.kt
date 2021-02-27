package by.it.academy.diexample.di

import by.it.academy.diexample.data.ArticlesDomainModelMapper
import by.it.academy.diexample.data.NewsDataRepository
import by.it.academy.diexample.data.NewsDataRepositoryImpl
import by.it.academy.diexample.datasouce.ArticlesDataModel
import by.it.academy.diexample.datasouce.NewsDataSource
import by.it.academy.diexample.datasouce.network.ApiController
import by.it.academy.diexample.domain.ArticlesDomainModel
import by.it.academy.diexample.domain.NewsTopHeadlinesUseCase
import by.it.academy.diexample.domain.NewsTopHeadlinesUseCaseImpl
import by.it.academy.diexample.presentation.NewsItem
import by.it.academy.diexample.presentation.NewsItemMapper
import by.it.academy.diexample.presentation.NewsListViewModel
import io.reactivex.disposables.CompositeDisposable
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.core.qualifier.named
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

val viewModelModule = module {
    viewModel { NewsListViewModel(get(), get(), get(named("NewsItemMapper"))) }
}

val mapperModule = module {
    factory<(List<ArticlesDomainModel>) -> List<NewsItem>>(named("NewsItemMapper")) {
        NewsItemMapper()
    }
    factory<(List<ArticlesDataModel>) -> List<ArticlesDomainModel>>(named("ArticlesDomainModelMapper")) {
        ArticlesDomainModelMapper()
    }
}

val rxModule = module {
    factory { CompositeDisposable() }
}

val useCaseModule = module {
    factory<NewsTopHeadlinesUseCase> { NewsTopHeadlinesUseCaseImpl(get()) }
}

val repoModule = module {
    factory<NewsDataRepository> { NewsDataRepositoryImpl(get(), get(named("ArticlesDomainModelMapper"))) }
}

val dataSourceModule = module {
    single {
        Retrofit.Builder()
            .baseUrl("https://newsapi.org/")
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .build()
    }

    factory<NewsDataSource> { ApiController(get()) }
}