package com.example.imdb_api_clean_architecture.data.dto

class MoviesSearchResponse(val searchType: String,
                           val expression: String,
                           val results: List<MovieDto>) : Response()