package com.tmdb.ui.di.module

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.tmdb.ui.MultiViewModelFactory
import com.tmdb.ui.core.di.qualifiers.ViewModelKey
import com.tmdb.ui.navigation.viewModel.HomeComponentViewModel
import com.tmdb.ui.navigation.viewModel.MovieDetailsComponentViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelBindingModule {
    @Binds
    fun viewModelFactory(impl: MultiViewModelFactory): ViewModelProvider.Factory

    @[Binds IntoMap ViewModelKey(HomeComponentViewModel::class)]
    fun homeComponentViewModel(homeComponentViewModel: HomeComponentViewModel): ViewModel

    @[Binds IntoMap ViewModelKey(MovieDetailsComponentViewModel::class)]
    fun movieDetailsComponentViewModel(movieDetailsComponentViewModel: MovieDetailsComponentViewModel): ViewModel
}
