package com.example.imdb_api_clean_architecture.util

import android.app.Activity
import android.content.Context
import com.example.imdb_api_clean_architecture.data.MoviesRepositoryImpl
import com.example.imdb_api_clean_architecture.data.network.RetrofitNetworkClient
import com.example.imdb_api_clean_architecture.domain.api.MoviesInteractor
import com.example.imdb_api_clean_architecture.domain.api.MoviesRepository
import com.example.imdb_api_clean_architecture.domain.impl.MoviesInteractorImpl
import com.example.imdb_api_clean_architecture.presentation.movies.MoviesSearchController
import com.example.imdb_api_clean_architecture.presentation.PosterController
import com.example.imdb_api_clean_architecture.ui.movies.MoviesAdapter

object Creator {
    private fun getMoviesRepository(context:Context): MoviesRepository {
        return MoviesRepositoryImpl(RetrofitNetworkClient(context))
    }

    fun provideMoviesInteractor(context:Context): MoviesInteractor {
        return MoviesInteractorImpl(getMoviesRepository(context))
    }
    fun provideMoviesSearchController(activity: Activity, adapter: MoviesAdapter,): MoviesSearchController {
        return MoviesSearchController(activity, adapter)
    }
    fun providePosterController(activity: Activity, adapter: MoviesAdapter):PosterController{
        return PosterController(activity)
    }
}