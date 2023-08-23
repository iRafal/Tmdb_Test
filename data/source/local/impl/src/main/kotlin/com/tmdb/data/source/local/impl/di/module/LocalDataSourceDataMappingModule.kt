package com.tmdb.data.source.local.impl.di.module

import com.tmdb.data.source.local.impl.movie.data.mapping.MovieDataModelToEntityMapper
import com.tmdb.data.source.local.impl.movie.data.mapping.MovieDataModelToEntityMapperImpl
import com.tmdb.data.source.local.impl.movie.data.mapping.MovieEntityToDataModelMapper
import com.tmdb.data.source.local.impl.movie.data.mapping.MovieEntityToDataModelMapperImpl
import dagger.Binds
import dagger.Module


@Module
interface LocalDataSourceDataMappingModule {
    @Binds
    fun movieEntityToDataModelMapper(impl: MovieEntityToDataModelMapperImpl): MovieEntityToDataModelMapper

    @Binds
    fun movieDataModelToEntityMapper(impl: MovieDataModelToEntityMapperImpl): MovieDataModelToEntityMapper
}
