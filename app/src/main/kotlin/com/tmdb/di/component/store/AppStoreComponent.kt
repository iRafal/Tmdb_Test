package com.tmdb.di.component.store

import android.content.Context
import com.tmdb.data.source.local.impl.di.component.LocalDataSourceInjections
import com.tmdb.data.source.remote.implKtor.di.component.RemoteDataSourceInjections
import com.tmdb.di.component.store.module.app.AppStoreModule
import com.tmdb.store.app.AppStore
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.BindsInstance
import dagger.Component

@ApplicationScope
@Component(
    dependencies = [RemoteDataSourceInjections::class, LocalDataSourceInjections::class],
    modules = [AppStoreModule::class]

)
interface AppStoreComponent {

    val appStore: AppStore

    @Component.Builder
    interface Builder {
        fun remoteDataSourceInjections(dependencies: RemoteDataSourceInjections): Builder
        fun localDataSourceInjections(dependencies: LocalDataSourceInjections): Builder

        @BindsInstance
        fun appContext(@ApplicationContext dependency: Context): Builder

        fun build(): AppStoreComponent
    }
}
