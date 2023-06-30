package com.tmdb

import android.app.Application
import android.os.StrictMode
import android.os.StrictMode.VmPolicy
import coil.Coil
import coil.ImageLoader
import com.tmdb.di.component.AppComponent
import com.tmdb.di.component.AppComponentStore
import com.tmdb.util.logging.AndroidReleaseLogcatLogger
import com.tmdb.utill.di.qualifiers.ApplicationScope
import javax.inject.Inject
import logcat.AndroidLogcatLogger

class MovieApp : Application()/*, Configuration.Provider*/ {

    //TODO
//    @Inject
//    lateinit var workerFactory: HiltWorkerFactory

    @Inject
    @ApplicationScope
    lateinit var coilImageLoader: ImageLoader

    internal lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        initLogging()
//        initIoStrictPolicy()

        AppComponentStore.init(this)
        appComponent = AppComponentStore.component.also { it.inject(this) }

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
