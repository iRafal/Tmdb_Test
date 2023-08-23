package com.tmdb.feature.movie.details.ui.di

import android.content.Context

val Context.movieDetailsFeatureComponent: MovieDetailsFeatureComponent
    get() {
        if (this is MovieDetailsFeatureComponentProvider) return this.movieDetailsFeatureComponent
        return (this.applicationContext as? MovieDetailsFeatureComponentProvider)?.movieDetailsFeatureComponent
            ?: throw IllegalStateException("No Implementation of ${MovieDetailsFeatureComponentProvider::class} found")
    }