package com.tmdb.data.source.remote.implKtor.di.module

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.data.source.remote.implKtor.mapping.MovieApiModelToDataModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.MovieApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.MoviesListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.implKtor.mapping.apiModelListToDataStateMapperImpl
import com.tmdb.data.source.remote.implKtor.mapping.apiModelToDataStateMapperImpl
import com.tmdb.data.source.remote.implKtor.mapping.movieApiToDataModelMapperImpl
import dagger.Module
import dagger.Provides


@Module
object MovieMappingModule {
    @Provides
    fun movieApiToDataModelMapper(
        imageUrlProvider: ImageUrlProvider
    ): @JvmSuppressWildcards MovieApiModelToDataModelMapper = movieApiToDataModelMapperImpl(imageUrlProvider)

    @Provides
    fun movieApiModelToDataStateModelMapper(
        movieApiModelToDataModelMapper: @JvmSuppressWildcards MovieApiModelToDataModelMapper
    ): @JvmSuppressWildcards MovieApiModelToDataStateModelMapper = apiModelToDataStateMapperImpl(movieApiModelToDataModelMapper)

    @Provides
    fun moviesApiToDataStateMapper(
        movieApiModelToDataModelMapper: @JvmSuppressWildcards MovieApiModelToDataModelMapper
    ): @JvmSuppressWildcards MoviesListApiModelToDataStateModelMapper = apiModelListToDataStateMapperImpl(movieApiModelToDataModelMapper)
}
