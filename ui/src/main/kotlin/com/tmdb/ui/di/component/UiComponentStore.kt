package com.tmdb.ui.di.component

import android.content.Context
import com.tmdb.store.app.AppStore
import com.tmdb.utill.di.qualifiers.ApplicationContext

object UiComponentStore {
    private var _component: UiComponent? = null
    val component: UiComponent
        get() = checkNotNull(_component)

    fun init(@ApplicationContext applicationContext: Context, appStore: AppStore) {
        if (_component != null) return

        val dependencies = object : UiComponentDependencies {
            override val applicationContext: Context
                get() = applicationContext
        }
        _component = DaggerUiComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}
