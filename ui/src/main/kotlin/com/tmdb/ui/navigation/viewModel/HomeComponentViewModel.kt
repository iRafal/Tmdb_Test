package com.tmdb.ui.navigation.viewModel

import androidx.lifecycle.ViewModel
import com.tmdb.feature.home.ui.di.component.HomeFeatureComponentStore
import com.tmdb.store.app.di.component.AppStoreComponentStore
import javax.inject.Inject

class HomeComponentViewModel @Inject constructor() : ViewModel() {

    init {
        HomeFeatureComponentStore.init(AppStoreComponentStore.component.appStore)
    }

    override fun onCleared() {
        super.onCleared()
        HomeFeatureComponentStore.clean()
    }
}
