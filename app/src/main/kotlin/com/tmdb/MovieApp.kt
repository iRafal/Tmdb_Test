package com.tmdb

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import coil.Coil
import coil.ImageLoader
import com.tmdb.di.component.app.AppComponent
import com.tmdb.di.component.app.AppComponentStore
import com.tmdb.di.component.store.AppStoreComponentStore
import com.tmdb.feature.home.ui.di.component.DaggerHomeFeatureComponent
import com.tmdb.feature.home.ui.di.component.HomeFeatureComponent
import com.tmdb.feature.home.ui.di.component.HomeFeatureComponentDependencies
import com.tmdb.feature.home.ui.di.component.HomeFeatureComponentProvider
import com.tmdb.feature.movie.details.ui.di.component.DaggerMovieDetailsFeatureComponent
import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponent
import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponentDependencies
import com.tmdb.feature.movie.details.ui.di.component.MovieDetailsFeatureComponentProvider
import com.tmdb.store.app.AppStore
import com.tmdb.util.logging.AndroidReleaseLogcatLogger
import com.tmdb.utill.di.qualifiers.ApplicationScope
import javax.inject.Inject
import logcat.AndroidLogcatLogger

class MovieApp : Application(), HomeFeatureComponentProvider, MovieDetailsFeatureComponentProvider/*, Configuration.Provider*/ {

    //TODO
//    @Inject
//    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    @ApplicationScope
    lateinit var coilImageLoader: ImageLoader

    val appComponent: AppComponent
        get() = AppComponentStore.component

    override val homeFeatureComponent: HomeFeatureComponent
        get() = DaggerHomeFeatureComponent.builder().dependencies(
            object : HomeFeatureComponentDependencies {
                override val appStore: AppStore
                    get() = AppStoreComponentStore.component.appStore
            }
        ).build()

    override val movieDetailsFeatureComponent: MovieDetailsFeatureComponent
        get() = DaggerMovieDetailsFeatureComponent.builder().dependencies(
            object : MovieDetailsFeatureComponentDependencies {
                override val appStore: AppStore
                    get() = AppStoreComponentStore.component.appStore
            }
        ).build()

    override fun onCreate() {
        super.onCreate()
        initLogging()
//        initIoStrictPolicy()

        AppComponentStore.init(this)
        AppComponentStore.component.inject(this)

        initCoil()
    }

    private fun initLogging() {
        if (BuildConfig.DEBUG) {
            AndroidLogcatLogger.installOnDebuggableApp(this)
        } else {
            AndroidReleaseLogcatLogger.installOnReleaseApp(
                this,
                onErrorLog = { priority, tag, message -> /* TODO pass logs to crash tracking tool */ }
            )
        }
    }

    //TODO
//    override fun getWorkManagerConfiguration(): Configuration =
//        Configuration.Builder()
//            .setWorkerFactory(workerFactory)
//            .build()

    private fun initCoil() {
        Coil.setImageLoader(coilImageLoader)
    }

    private fun initIoStrictPolicy() {
        StrictMode.setThreadPolicy(
            StrictMode.ThreadPolicy.Builder()
                .detectDiskReads()
                .detectDiskWrites()
                .detectAll()
                .penaltyLog()
                .build()
        )
        StrictMode.setVmPolicy(
            VmPolicy.Builder()
                .detectLeakedSqlLiteObjects()
                .detectLeakedClosableObjects()
                .penaltyLog()
                .build()
        )
    }

    override fun onTerminate() {
        super.onTerminate()
        AppComponentStore.clean()
    }

    override fun onLowMemory() {
        super.onLowMemory()
        AppComponentStore.clean()
    }
}
