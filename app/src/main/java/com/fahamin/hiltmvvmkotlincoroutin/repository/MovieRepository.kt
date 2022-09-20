package com.fahamin.hiltmvvmkotlincoroutin.repository

import com.fahamin.hiltmvvmkotlincoroutin.NetworkResult
import com.fahamin.hiltmvvmkotlincoroutin.api.Api
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class MovieRepository @Inject constructor( private var  api: Api) {
    suspend fun getPopularMovies()  = flow {
        emit(NetworkResult.Loading(true))
        val response = api.getResponse()
        emit(NetworkResult.Success(response.items))
    }.catch { e ->
        emit(NetworkResult.Failure(e.message ?: "Unknown Error"))
    }

}