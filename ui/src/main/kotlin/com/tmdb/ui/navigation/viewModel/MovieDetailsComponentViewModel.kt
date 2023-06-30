package com.tmdb.ui.navigation.viewModel

import androidx.lifecycle.ViewModel
import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponentStore
import com.tmdb.store.app.di.component.AppStoreComponentStore
import javax.inject.Inject

class MovieDetailsComponentViewModel @Inject constructor() : ViewModel() {

    init {
        MovieDetailsFeatureComponentStore.init(AppStoreComponentStore.component.appStore)
    }

    override fun onCleared() {
        super.onCleared()
        MovieDetailsFeatureComponentStore.clean()
    }
}
