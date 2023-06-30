package com.tmdb.store.app.di.component

import com.tmdb.store.app.AppStore
import com.tmdb.store.app.di.module.AppStoreModule
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(dependencies = [AppStoreComponentDependencies::class], modules = [AppStoreModule::class])]
interface AppStoreComponent {

    val appStore: AppStore

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: AppStoreComponentDependencies): Builder
        fun build(): AppStoreComponent
    }
}
