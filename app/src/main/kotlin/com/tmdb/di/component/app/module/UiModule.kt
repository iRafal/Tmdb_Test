package com.tmdb.di.component.app.module

import com.tmdb.ui.core.di.module.ImageLoadingModule
import dagger.Module

@Module(includes = [ViewModelBindingModule::class, ImageLoadingModule::class])
object UiModule
