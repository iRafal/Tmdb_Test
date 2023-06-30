package com.tmdb.data.source.local.impl.realm.di.module

import com.tmdb.data.source.local.impl.realm.MovieLocalDataSourceImpl
import com.tmdb.data.source.remote.contract.MovieLocalDataSource
import dagger.Binds
import dagger.Module


@Module(includes = [LocalDataSourceDataMappingModule::class])
interface LocalDataSourceModule {
    @Binds
    fun movieLocalDataSource(impl: MovieLocalDataSourceImpl): MovieLocalDataSource
}
