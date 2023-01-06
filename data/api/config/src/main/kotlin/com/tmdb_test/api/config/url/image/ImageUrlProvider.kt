package com.tmdb_test.api.config.url.image

import com.tmdb_test.api.config.url.image.PosterImageSize.W_500

/*
  https://www.themoviedb.org/talk/5aeaaf56c3a3682ddf0010de
 */
interface ImageUrlProvider {
    fun posterUrl(path: String, size: PosterImageSize = W_500): String
}