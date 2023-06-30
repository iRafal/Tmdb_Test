package com.tmdb.ui.di.component

import coil.ImageLoader
import com.tmdb.ui.di.module.UiModule
import com.tmdb.ui.main.MainActivity
import com.tmdb.ui.navigation.viewModel.HomeComponentViewModel
import com.tmdb.ui.navigation.viewModel.MovieDetailsComponentViewModel
import com.tmdb.utill.di.qualifiers.ApplicationScope
import dagger.Component

@[ApplicationScope Component(modules = [UiModule::class], dependencies = [UiComponentDependencies::class])]
interface UiComponent {

    val coilImageLoader: ImageLoader

    val homeComponentViewModel: HomeComponentViewModel

    val movieDetailsComponentViewModel: MovieDetailsComponentViewModel

    fun inject(inject: MainActivity)

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: UiComponentDependencies): Builder
        fun build(): UiComponent
    }
}
