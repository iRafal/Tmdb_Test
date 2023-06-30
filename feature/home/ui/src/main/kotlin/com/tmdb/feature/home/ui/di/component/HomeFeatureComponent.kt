package com.tmdb.feature.home.ui.di.component

import com.tmdb.feature.home.ui.HomeViewModel
import com.tmdb.feature.home.ui.di.module.HomeFeatureModule
import com.tmdb.ui.core.di.qualifiers.FeatureScope
import dagger.Component


@[FeatureScope Component(modules = [HomeFeatureModule::class], dependencies = [HomeFeatureComponentDependencies::class])]
interface HomeFeatureComponent {

    val homeViewModel: HomeViewModel

    @Component.Builder
    interface Builder {
        fun dependencies(dependencies: HomeFeatureComponentDependencies): Builder
        fun build(): HomeFeatureComponent
    }
}
