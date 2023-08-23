package com.tmdb.di.component.app

import android.content.Context
import coil.ImageLoader
import com.tmdb.MovieApp
import com.tmdb.di.component.app.module.AppModule
import com.tmdb.store.AppStore
import com.tmdb.ui.core.di.base.HasAppContext
import com.tmdb.ui.main.MainActivity
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [AppComponentDependencies::class])
@ApplicationScope
interface AppComponent: HasAppContext {

    @get:ApplicationScope
    val imageLoader: ImageLoader

    fun inject(inject: MovieApp)
    fun inject(inject: MainActivity)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: AppComponentDependencies): Builder

        fun build(): AppComponent
    }
}

interface AppComponentDependencies {
    @get:ApplicationContext
    val applicationContext: Context

    val appStore: AppStore
}
