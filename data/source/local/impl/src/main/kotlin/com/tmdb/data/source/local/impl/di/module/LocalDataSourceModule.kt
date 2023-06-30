package com.tmdb.data.source.local.impl.di.module

import com.tmdb.data.source.local.impl.MovieLocalDataSourceImpl
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import dagger.Binds
import dagger.Module


@Module(includes = [LocalDataSourceDataMappingModule::class])
interface LocalDataSourceModule {
    @Binds
    fun movieLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource
}
