package com.example.imdb_api_clean_architecture.domain.api

import com.example.imdb_api_clean_architecture.util.Resource
import com.example.imdb_api_clean_architecture.domain.models.Movie



interface MoviesRepository {
    fun searchMovies(expression: String): Resource<List<Movie>>
}