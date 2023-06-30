package com.tmdb.data.model.mapping.di.component

import com.tmdb.api.config.url.di.component.ApiConfigComponentStore
import com.tmdb.api.config.url.image.contract.ImageUrlProvider

object DataModelMappingComponentStore {
    private var _component: DataModelMappingComponent? = null
    val component: DataModelMappingComponent
        get() = checkNotNull(_component)

    fun init() {
        if (_component != null) return

        ApiConfigComponentStore.init()

        val dependencies = object : DataModelMappingComponentDependencies {
            override val imageUrlProvider: ImageUrlProvider
                get() = ApiConfigComponentStore.component.imageUrlProvider

        }
        _component = DaggerDataModelMappingComponent.builder().dependencies(dependencies).build()
    }

    fun clean() {
        _component = null
    }
}