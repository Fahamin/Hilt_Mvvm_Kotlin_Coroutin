package com.fahamin.hiltmvvmkotlincoroutin.api

import com.fahamin.hiltmvvmkotlincoroutin.MovieResponse
import retrofit2.http.GET

interface Api {

    @GET("API/MostPopularMovies/k_9v5jw2c1")
    suspend fun getResponse(): MovieResponse
}