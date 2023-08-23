package com.tmdb.ui.core.di.base

import android.content.Context
import com.tmdb.utill.di.qualifiers.ApplicationContext

interface HasAppContext {
    @get:ApplicationContext
    val applicationContext: Context
}