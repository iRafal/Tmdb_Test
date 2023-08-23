package com.tmdb.feature.home.ui.di

import android.content.Context

val Context.homeFeatureComponent: HomeFeatureComponent
    get() {
        if (this is HomeFeatureComponentProvider) return this.homeFeatureComponent
        return (this.applicationContext as? HomeFeatureComponentProvider)?.homeFeatureComponent
            ?: throw IllegalStateException("No Implementation of ${HomeFeatureComponentProvider::class} found")
    }