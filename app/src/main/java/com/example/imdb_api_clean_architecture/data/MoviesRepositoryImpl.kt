package com.example.imdb_api_clean_architecture.data

import com.example.imdb_api_clean_architecture.data.dto.MoviesSearchRequest
import com.example.imdb_api_clean_architecture.data.dto.MoviesSearchResponse
import com.example.imdb_api_clean_architecture.util.Resource
import com.example.imdb_api_clean_architecture.domain.api.MoviesRepository
import com.example.imdb_api_clean_architecture.domain.models.Movie

class MoviesRepositoryImpl(private val networkClient: NetworkClient) : MoviesRepository {

    override fun searchMovies(expression: String): Resource<List<Movie>> {
        val response = networkClient.doRequest(MoviesSearchRequest(expression))
             return when(response.resultCode){
                 -1->{
                     Resource.Error("Проверьте подключение")
                 }
                 200->{
                     Resource.Success((response as MoviesSearchResponse).results.map {
                         Movie(it.id, it.image, it.title, it.description, it.resultType)})
                 }
                 else->{
                     Resource.Error("Ошибка сервера")
                 }
             }

    }
    }
