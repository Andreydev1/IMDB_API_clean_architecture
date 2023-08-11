package com.example.imdb_api_clean_architecture.ui.poster

import android.app.Activity
import android.os.Bundle
import com.example.imdb_api_clean_architecture.R
import com.example.imdb_api_clean_architecture.presentation.PosterController

class PosterActivity :Activity() {
    private val posterController = PosterController(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_poster)
        posterController.onCreate()
    }
}