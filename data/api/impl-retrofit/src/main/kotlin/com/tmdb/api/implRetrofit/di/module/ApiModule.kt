package com.tmdb.api.implRetrofit.di.module

import com.tmdb.api.config.url.di.module.UrlProviderModule
import com.tmdb.api.config.url.provider.base.BaseUrlProvider
import com.tmdb.api.implRetrofit.di.ApiDependenciesProvider
import com.tmdb.api.implRetrofit.di.module.ApiFactoriesModule.ConverterFactoryJson
import com.tmdb.api.implRetrofit.di.module.ApiFactoriesModule.ConverterFactoryScalars
import com.tmdb.api.implRetrofit.di.module.ApiHttpClientModule.OkHttpClientRetrofit
import com.tmdb.api.implRetrofit.discover.DiscoverApi
import com.tmdb.api.implRetrofit.genre.GenreApi
import com.tmdb.api.implRetrofit.movie.MovieApi
import com.tmdb.api.implRetrofit.person.PersonApi
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import retrofit2.CallAdapter
import retrofit2.Converter

@Module(includes = [ApiFactoriesModule::class, ApiHttpClientModule::class, ApiJsonModule::class, UrlProviderModule::class])
object ApiModule {

    @[Provides ApplicationScope]
    fun discoverApi(
        baseUrlProvider: BaseUrlProvider,
        @OkHttpClientRetrofit client: OkHttpClient,
        @ConverterFactoryJson jsonConverterFactory: Converter.Factory,
        @ConverterFactoryScalars scalarsConverterFactory: Converter.Factory,
        factory: CallAdapter.Factory
    ): DiscoverApi = ApiDependenciesProvider.api(
        url = baseUrlProvider.discoverApiUrl,
        client = client,
        jsonConverterFactory = jsonConverterFactory,
        scalarsConverterFactory = scalarsConverterFactory,
        factory = factory,
        apiClass = DiscoverApi::class.java
    )

    @[Provides ApplicationScope]
    fun genreApi(
        baseUrlProvider: BaseUrlProvider,
        @OkHttpClientRetrofit client: OkHttpClient,
        @ConverterFactoryJson jsonConverterFactory: Converter.Factory,
        @ConverterFactoryScalars scalarsConverterFactory: Converter.Factory,
        factory: CallAdapter.Factory
    ): GenreApi = ApiDependenciesProvider.api(
        url = baseUrlProvider.genreApiUrl,
        client = client,
        jsonConverterFactory = jsonConverterFactory,
        scalarsConverterFactory = scalarsConverterFactory,
        factory = factory,
        apiClass = GenreApi::class.java
    )

    @[Provides ApplicationScope]
    fun movieApi(
        baseUrlProvider: BaseUrlProvider,
        @OkHttpClientRetrofit client: OkHttpClient,
        @ConverterFactoryJson jsonConverterFactory: Converter.Factory,
        @ConverterFactoryScalars scalarsConverterFactory: Converter.Factory,
        factory: CallAdapter.Factory
    ): MovieApi = ApiDependenciesProvider.api(
        url = baseUrlProvider.movieApiUrl,
        client = client,
        jsonConverterFactory = jsonConverterFactory,
        scalarsConverterFactory = scalarsConverterFactory,
        factory = factory,
        apiClass = MovieApi::class.java
    )

    @[Provides ApplicationScope]
    fun personApi(
        baseUrlProvider: BaseUrlProvider,
        @OkHttpClientRetrofit client: OkHttpClient,
        @ConverterFactoryJson jsonConverterFactory: Converter.Factory,
        @ConverterFactoryScalars scalarsConverterFactory: Converter.Factory,
        factory: CallAdapter.Factory
    ): PersonApi = ApiDependenciesProvider.api(
        url = baseUrlProvider.personApiUrl,
        client = client,
        jsonConverterFactory = jsonConverterFactory,
        scalarsConverterFactory = scalarsConverterFactory,
        factory = factory,
        apiClass = PersonApi::class.java
    )
}