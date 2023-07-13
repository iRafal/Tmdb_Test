package com.tmdb.di.component.app.module

import androidx.lifecycle.ViewModelProvider
import com.tmdb.ui.MultiViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelBindingModule {
    @Binds
    fun viewModelFactory(impl: MultiViewModelFactory): ViewModelProvider.Factory
}
