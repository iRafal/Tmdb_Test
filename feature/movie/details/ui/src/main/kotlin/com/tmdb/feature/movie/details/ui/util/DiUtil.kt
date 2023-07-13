package com.tmdb.feature.movie.details.ui.util

import android.content.Context
import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponent
import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponentProvider

val Context.movieDetailsFeatureComponent: MovieDetailsFeatureComponent
    get() {
        if (this is MovieDetailsFeatureComponentProvider) return this.movieDetailsFeatureComponent
        return (this.applicationContext as? MovieDetailsFeatureComponentProvider)?.movieDetailsFeatureComponent
            ?: throw IllegalStateException("No Implementation of ${MovieDetailsFeatureComponentProvider::class} found")
    }