package com.example.imdb_api_clean_architecture.data

import com.example.imdb_api_clean_architecture.data.dto.Response

interface NetworkClient {
    fun doRequest(dto: Any): Response

}