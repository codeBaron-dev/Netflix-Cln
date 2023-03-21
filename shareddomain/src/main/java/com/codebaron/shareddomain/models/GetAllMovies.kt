package com.codebaron.shareddomain.models

data class GetAllMovies(
    val page: Int,
    val results: List<Result>,
    val total_pages: Int,
    val total_results: Int
)