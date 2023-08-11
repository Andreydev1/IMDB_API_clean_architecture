package com.example.imdb_api_clean_architecture.ui.movies

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.imdb_api_clean_architecture.util.Creator
import com.example.imdb_api_clean_architecture.R
import com.example.imdb_api_clean_architecture.ui.poster.PosterActivity

class MoviesActivity : Activity() {
    companion object {

        private const val SEARCH_DEBOUNCE_DELAY = 2000L
    }

    private lateinit var queryInput: EditText
    private lateinit var placeholderMessage: TextView
    private lateinit var moviesList: RecyclerView
    private lateinit var progressBar: ProgressBar


    private var isClickAllowed = true
    private val handler = Handler(Looper.getMainLooper())
    private val adapter = MoviesAdapter{
        if (clickDebounce()){
            val intent = Intent(this, PosterActivity :: class.java)
            intent.putExtra("poster", it.image)
            startActivity(intent)
        }
    }

    private val moviesSearchController = Creator.provideMoviesSearchController(this, adapter)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movies)
        moviesSearchController.onCreate()
        queryInput = findViewById(R.id.queryInput)
        placeholderMessage = findViewById(R.id.placeholderMessage)
        moviesList = findViewById(R.id.locations)
        progressBar = findViewById(R.id.progressBar)
    }
    private fun clickDebounce(): Boolean {
        var current = isClickAllowed
        if (isClickAllowed){
            isClickAllowed = false
            handler.postDelayed({isClickAllowed = true}, SEARCH_DEBOUNCE_DELAY)
        }
        return current
    }
    override fun onDestroy() {
        super.onDestroy()
        moviesSearchController.onDestroy()
    }
}



