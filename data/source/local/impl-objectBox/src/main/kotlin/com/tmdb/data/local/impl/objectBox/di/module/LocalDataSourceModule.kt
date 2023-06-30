package com.tmdb.data.local.impl.objectBox.di.module

import com.tmdb.data.local.impl.objectBox.MovieLocalDataSourceImpl
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import dagger.Binds
import dagger.Module


@Module(includes = [LocalDataSourceDataMappingModule::class])
interface LocalDataSourceModule {
    @Binds
    fun movieLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource
}
