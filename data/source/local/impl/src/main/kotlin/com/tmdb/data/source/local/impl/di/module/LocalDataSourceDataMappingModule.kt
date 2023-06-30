package com.tmdb.data.source.local.impl.di.module

import com.tmdb.data.source.local.impl.movie.data.mapping.MovieDataModelToEntityMapper
import com.tmdb.data.source.local.impl.movie.data.mapping.MovieEntityToDataModelMapper
import com.tmdb.data.source.local.impl.movie.data.mapping.movieDataModelToEntityMapperImpl
import com.tmdb.data.source.local.impl.movie.data.mapping.movieEntityToDataModelMapperImpl
import dagger.Module
import dagger.Provides


@Module
object LocalDataSourceDataMappingModule {
    @Provides
    fun movieEntityToDataModelMapper(): @JvmSuppressWildcards MovieEntityToDataModelMapper = ::movieEntityToDataModelMapperImpl

    @Provides
    fun movieDataModelToEntityMapper(): @JvmSuppressWildcards MovieDataModelToEntityMapper = ::movieDataModelToEntityMapperImpl
}
