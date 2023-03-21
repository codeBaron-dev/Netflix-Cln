package com.codebaron.shareddomain.utils

object AppConstants {
    const val BASE_URL = "https://api.themoviedb.org/3/"
    const val POPULAR_MOVIES_API = "movie/popular"
    const val API_KEY = "cbb2c4d1c8fdae3b9bbbef9250fdd002"
    const val TRENDING_MOVIES_API = "trending/{media_type}/{time_window}"
    const val TOP_RATED_MOVIES_API = "movie/top_rated"
    const val MOVIE_DETAILS = "movie/{movie_id}"
    const val MOVIE_CREDITS = "/movie/{movie_id}/credits"
    const val SIMILAR_MOVIES = "movie/{movie_id}/similar"
    const val IMAGE_BASE_URL = "http://image.tmdb.org/t/p/"
    const val IMAGE_PATH_URL = "https://image.tmdb.org/t/p/w500"
}