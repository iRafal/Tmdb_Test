package com.tmdb.di.component.app

import android.content.Context
import com.tmdb.store.app.AppStore
import com.tmdb.di.component.store.AppStoreComponentStore
import com.tmdb.utill.di.qualifiers.ApplicationContext

object AppComponentStore {
    private var _appComponent: AppComponent? = null
    val component: AppComponent
        get() = checkNotNull(_appComponent)

    fun init(@ApplicationContext context: Context) {
        if (_appComponent != null) return

        AppStoreComponentStore.init(context)

        val dependencies = object : AppComponentDependencies {
            override val applicationContext: Context
                get() = context

            override val appStore: AppStore
                get() = AppStoreComponentStore.component.appStore
        }

        _appComponent = DaggerAppComponent.builder()
            .dependencies(dependencies)
            .build()
    }

    fun clean() {
        _appComponent = null
        AppStoreComponentStore.clean()
    }
}
