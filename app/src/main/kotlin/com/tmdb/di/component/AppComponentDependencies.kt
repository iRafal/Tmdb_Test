package com.tmdb.di.component

import android.content.Context
import coil.ImageLoader
import com.tmdb.store.app.AppStore
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope

interface AppComponentDependencies {
    @get:ApplicationContext
    val applicationContext: Context

    val appStore: AppStore

    @get:ApplicationScope
    val imageLoader: ImageLoader
}