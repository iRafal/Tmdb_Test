package com.tmdb.ui.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.Composable
import com.tmdb.feature.home.ui.di.HomeFeatureDi
import com.tmdb.feature.movie.details.ui.di.MovieDetailsFeatureDi
import com.tmdb.store.AppStore
import com.tmdb.ui.core.theme.TmdbTheme
import com.tmdb.ui.navigation.AppNavigation
import com.tmdb.util.appComponent
import com.tmdb.util.appStoreComponent
import javax.inject.Inject

class MainActivity : ComponentActivity(), HomeFeatureDi.Component.Dependencies, MovieDetailsFeatureDi.Component.Dependencies {

    @Inject
    lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        appComponent.inject(this)
        setContent { SetContent() }
    }

    @Composable
    private fun SetContent() {
        TmdbTheme { AppNavigation(onClose = { finish() }) }
    }

    override val appStore: AppStore
        get() = appStoreComponent.appStore
}
