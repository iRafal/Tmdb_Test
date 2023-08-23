package com.tmdb.data.source.remote.impl.di.component

import com.tmdb.api.implRetrofit.di.component.HasApiServices
import com.tmdb.data.source.remote.impl.di.module.RemoteDataSourceModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@ApplicationScope
@Component(modules = [RemoteDataSourceModule::class], dependencies = [HasApiServices::class])
interface RemoteDataSourceComponent: HasRemoteDataSources {

    @Component.Builder
    interface Builder {
        fun apiInjections(dependencies: HasApiServices): Builder
        fun build(): RemoteDataSourceComponent
    }
}
