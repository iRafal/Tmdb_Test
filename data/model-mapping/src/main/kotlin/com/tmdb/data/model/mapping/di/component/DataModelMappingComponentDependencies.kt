package com.tmdb.data.model.mapping.di.component

import com.tmdb.api.config.url.image.contract.ImageUrlProvider

interface DataModelMappingComponentDependencies {
    val imageUrlProvider: ImageUrlProvider
}
