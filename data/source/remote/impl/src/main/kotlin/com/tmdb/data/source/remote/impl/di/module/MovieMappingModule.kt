package com.tmdb.data.source.remote.impl.di.module

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.data.source.remote.impl.mapping.apiModelListToDataStateMapperImpl
import com.tmdb.data.source.remote.impl.mapping.apiModelToDataStateMapperImpl
import com.tmdb.data.source.remote.impl.mapping.MovieApiModelToDataModelMapper
import com.tmdb.data.source.remote.impl.mapping.MovieApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.MoviesListApiModelToDataStateModelMapper
import com.tmdb.data.source.remote.impl.mapping.movieApiToDataModelMapperImpl
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
