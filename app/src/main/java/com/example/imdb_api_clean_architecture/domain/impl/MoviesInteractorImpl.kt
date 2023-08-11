package com.example.imdb_api_clean_architecture.domain.impl

import com.bumptech.glide.util.Executors
import com.example.imdb_api_clean_architecture.util.Resource
import com.example.imdb_api_clean_architecture.domain.api.MoviesInteractor
import com.example.imdb_api_clean_architecture.domain.api.MoviesRepository


class MoviesInteractorImpl(private val repository: MoviesRepository) : MoviesInteractor {
    private val executor = Executors.mainThreadExecutor()
    override fun searchMovies(expression: String, consumer: MoviesInteractor.MoviesConsumer) {
       executor.execute{
           when(val resource = repository.searchMovies(expression)){
               is Resource.Success -> {consumer.consume(resource.data, null)}
               is Resource.Error -> {consumer.consume(null, resource.message)}
           }
       }
    }

}

