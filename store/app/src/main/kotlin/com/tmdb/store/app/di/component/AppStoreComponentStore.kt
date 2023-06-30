package com.tmdb.store.app.di.component

import android.content.Context
import com.tmdb.store.env.contract.AppEnv
import com.tmdb.store.env.di.component.AppEnvComponentStore
import com.tmdb.store.reducer.app.AppReducer
import com.tmdb.store.reducer.app.di.component.AppReducerComponentStore
import com.tmdb.store.state.di.component.AppStateComponentStore
import com.tmdb.utill.di.qualifiers.ApplicationContext

object AppStoreComponentStore {
    private var _component: AppStoreComponent? = null
    val component: AppStoreComponent
        get() = checkNotNull(_component)

    fun init(@ApplicationContext applicationContext: Context) {
        AppStateComponentStore.init()
        AppEnvComponentStore.init(applicationContext)
        AppReducerComponentStore.init()

        val dependencies = object : AppStoreComponentDependencies{
            override val applicationContext: Context
                get() = applicationContext

            override val appEnv: AppEnv
                get() = AppEnvComponentStore.component.appEnv

            override val appReducer: AppReducer
                get() = AppReducerComponentStore.component.appReducer
        }
        _component = DaggerAppStoreComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
        AppStateComponentStore.clean()
        AppEnvComponentStore.clean()
        AppReducerComponentStore.clean()
    }
}
