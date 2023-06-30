package com.tmdb.ui.di.component

import android.content.Context
import com.tmdb.utill.di.qualifiers.ApplicationContext

interface UiComponentDependencies {
    @get:ApplicationContext
    val applicationContext: Context
}
