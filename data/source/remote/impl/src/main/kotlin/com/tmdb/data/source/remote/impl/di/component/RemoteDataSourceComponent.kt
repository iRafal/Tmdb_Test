package com.tmdb.data.source.remote.impl.di.component

import com.tmdb.api.implRetrofit.di.component.ApiInjections
import com.tmdb.data.source.remote.impl.di.module.RemoteDataSourceModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [RemoteDataSourceModule::class], dependencies = [ApiInjections::class])
interface RemoteDataSourceComponent: RemoteDataSourceInjections {

    @Component.Builder
    interface Builder {
        fun apiInjections(dependencies: ApiInjections): Builder
        fun build(): RemoteDataSourceComponent
    }
}
