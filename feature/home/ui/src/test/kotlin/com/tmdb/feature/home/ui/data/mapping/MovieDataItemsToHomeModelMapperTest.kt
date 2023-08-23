package com.tmdb.feature.home.ui.data.mapping

import com.tmdb.feature.home.ui.util.ModelUtil
import org.junit.Assert.assertEquals
import org.junit.Test

class MovieDataItemsToHomeModelMapperTest {

    private val itemMapper: MovieDataToHomeModelMapper = MovieDataToHomeModelMapperImpl()
    private val listMapper: MovieDataItemsToHomeModelMapper = MovieDataItemsToHomeModelMapperImpl(itemMapper)

    @Test
    fun mapModel() {
        val input = listOf(ModelUtil.movieDataModel)
        val actual = listMapper.map(input)
        val expected = listOf(ModelUtil.uiModelMovie)
        assertEquals(expected, actual)
    }
}
