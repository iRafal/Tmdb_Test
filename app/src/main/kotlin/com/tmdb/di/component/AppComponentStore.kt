package com.tmdb.di.component

import android.content.Context
import coil.ImageLoader
import com.tmdb.store.app.AppStore
import com.tmdb.store.app.di.component.AppStoreComponentStore
import com.tmdb.ui.di.component.UiComponentStore
import com.tmdb.utill.di.qualifiers.ApplicationContext

object AppComponentStore {
    private var _appComponent: AppComponent? = null
    val component: AppComponent
        get() = checkNotNull(_appComponent)

    fun init(@ApplicationContext context: Context) {
        if (_appComponent != null) return

        AppStoreComponentStore.init(context)
        UiComponentStore.init(context, AppStoreComponentStore.component.appStore)

        val dependencies = object : AppComponentDependencies {
            override val applicationContext: Context
                get() = context

            override val appStore: AppStore
                get() = AppStoreComponentStore.component.appStore

            override val imageLoader: ImageLoader
                get() = UiComponentStore.component.coilImageLoader
        }
        _appComponent = DaggerAppComponent.builder()
            .dependencies(dependencies)
            .build()
    }

    fun clean() {
        _appComponent = null
        UiComponentStore.clean()
        AppStoreComponentStore.clean()
    }
}