package com.tmdb.api.config.url.di.component

object ApiConfigComponentStore {
    private var _component: ApiConfigComponent? = null
    val component: ApiConfigComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component == null) {
            _component = DaggerApiConfigComponent.builder().build()
        }
    }

    fun clean() {
        _component = null
    }
}