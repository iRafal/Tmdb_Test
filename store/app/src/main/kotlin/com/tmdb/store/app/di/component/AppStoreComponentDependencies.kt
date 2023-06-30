package com.tmdb.store.app.di.component

import android.content.Context
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.reducer.app.AppReducer
import com.tmdb.utill.di.qualifiers.ApplicationContext

interface AppStoreComponentDependencies {
    @get:ApplicationContext
    val applicationContext: Context

    val appEnv: AppEnv

    val appReducer: @JvmSuppressWildcards AppReducer
}
