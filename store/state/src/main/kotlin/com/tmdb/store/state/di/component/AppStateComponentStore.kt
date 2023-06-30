package com.tmdb.store.state.di.component

object AppStateComponentStore {
    private var _component: AppStateComponent? = null
    val component: AppStateComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return
        _component = DaggerAppStateComponent.builder().build()
    }

    fun clean() {
        _component = null
    }
}
