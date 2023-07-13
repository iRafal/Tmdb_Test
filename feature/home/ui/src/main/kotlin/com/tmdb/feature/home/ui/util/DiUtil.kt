package com.tmdb.feature.home.ui.util

import android.content.Context
import com.tmdb.feature.home.ui.di.component.HomeFeatureComponent
import com.tmdb.feature.home.ui.di.component.HomeFeatureComponentProvider

val Context.homeFeatureComponent: HomeFeatureComponent
    get() {
        if (this is HomeFeatureComponentProvider) return this.homeFeatureComponent
        return (this.applicationContext as? HomeFeatureComponentProvider)?.homeFeatureComponent
            ?: throw IllegalStateException("No Implementation of ${HomeFeatureComponentProvider::class} found")
    }