package com.tmdb.data.local.impl.objectBox.di.module

import com.tmdb.data.local.impl.objectBox.mapping.MovieDataModelToEntityMapper
import com.tmdb.data.local.impl.objectBox.mapping.MovieEntityToDataModelMapper
import com.tmdb.data.local.impl.objectBox.mapping.movieDataModelToEntityMapperImpl
import com.tmdb.data.local.impl.objectBox.mapping.movieEntityToDataModelMapperImpl
import dagger.Module
import dagger.Provides


@Module
object LocalDataSourceDataMappingModule {
    @Provides
    fun movieEntityToDataModelMapper(): @JvmSuppressWildcards MovieEntityToDataModelMapper =
        ::movieEntityToDataModelMapperImpl

    @Provides
    fun movieDataModelToEntityMapper(): @JvmSuppressWildcards MovieDataModelToEntityMapper =
        ::movieDataModelToEntityMapperImpl
}
