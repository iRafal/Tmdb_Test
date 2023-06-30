package com.tmdb.feature.home.ui.di.module

import dagger.Module

@Module(includes = [ViewModelBindingModule::class, HomeUiDataMappingModule::class])
object HomeFeatureModule
