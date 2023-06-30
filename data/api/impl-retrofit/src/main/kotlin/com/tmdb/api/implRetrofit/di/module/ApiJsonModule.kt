package com.tmdb.api.implRetrofit.di.module

import com.tmdb.api.implRetrofit.di.ApiDependenciesProvider
import dagger.Module
import dagger.Provides


@Module
object ApiJsonModule {

    @Provides
    fun json() = ApiDependenciesProvider.json()
}
