package com.example.domain.repository

import com.example.domain.model.Movie

interface MovieRepository {
    suspend fun getMovies(): List<Movie>
}
