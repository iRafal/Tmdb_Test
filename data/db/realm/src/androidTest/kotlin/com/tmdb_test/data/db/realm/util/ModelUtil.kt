package com.tmdb_test.data.db.realm.util

import com.tmdb_test.data.db.realm.movie.MovieEntity
import kotlinx.datetime.LocalDate

object ModelUtil {
    val movieId = 550
    val title = "Fight Club"
    val voteAverage = 7.8
    val releaseDate = LocalDate.parse("1999-10-12")
    val posterUrl = "https://web.page.com/posterUrl"
    val isNowPlaying = false
    val isNowPopular = false
    val isTopRated = false
    val isUpcoming = false

    val movieEntity = MovieEntity(
        id = movieId,
        title = title,
        voteAverage = voteAverage,
        releaseDateAsString = null,
        posterUrl = posterUrl,
        isNowPlaying = isNowPlaying,
        isNowPopular = isNowPopular,
        isTopRated = isTopRated,
        isUpcoming = isUpcoming
    ).apply {
        releaseDate = ModelUtil.releaseDate
    }
}