package com.example.imdb_api_clean_architecture.domain.api

import com.example.imdb_api_clean_architecture.domain.models.Movie

interface MoviesInteractor {
    fun searchMovies(expression: String, consumer: MoviesConsumer)

    interface MoviesConsumer {
        fun consume(foundMovies: List<Movie>?, errorMessage:String?)
    }
}