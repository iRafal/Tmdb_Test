package com.tmdb.data.source.local.impl.realm.di.module

import com.tmdb.data.source.local.impl.realm.mapping.MovieDataModelToEntityMapper
import com.tmdb.data.source.local.impl.realm.mapping.MovieEntityToDataModelMapper
import com.tmdb.data.source.local.impl.realm.mapping.movieDataModelToEntityMapperImpl
import com.tmdb.data.source.local.impl.realm.mapping.movieEntityToDataModelMapperImpl
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
