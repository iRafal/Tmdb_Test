package com.tmdb.di.component

import android.content.Context
import coil.ImageLoader
import com.tmdb.MovieApp
import com.tmdb.di.module.AppModule
import com.tmdb.utill.di.qualifiers.ApplicationContext
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@Component(modules = [AppModule::class], dependencies = [AppComponentDependencies::class])
@ApplicationScope
interface AppComponent {

    @get:ApplicationContext
    val applicationContext: Context

    fun inject(inject: MovieApp)

    @get:ApplicationScope
    val imageLoader: ImageLoader

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: AppComponentDependencies): Builder

        fun build(): AppComponent
    }
}
