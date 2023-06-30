package com.tmdb.data.model.mapping.movie

import com.tmdb.api.config.url.image.contract.ImageUrlProvider
import com.tmdb.api.config.url.image.impl.ImageUrlProviderImpl
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieApiToDataModelMapperTest {
    private val baseUrl = "https://web.site.com"
    private val imageUrlProvider: ImageUrlProvider = ImageUrlProviderImpl(baseUrl)
    private val mapper: MovieApiToDataModelMapper = movieApiToDataModelMapperImpl(imageUrlProvider)

    @Test
    fun testMapApiToDataModel() {
        val input = com.tmdb.data.model.mapping.util.ModelUtil.movieModel
        val actual = mapper.invoke(input)
        val expected = com.tmdb.data.model.mapping.util.ModelUtil.movieDataModel
        assertEquals(expected, actual)
    }
}
