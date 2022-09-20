package com.fahamin.hiltmvvmkotlincoroutin.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.fahamin.hiltmvvmkotlincoroutin.Movie
import com.fahamin.hiltmvvmkotlincoroutin.NetworkResult
import com.fahamin.hiltmvvmkotlincoroutin.repository.MovieRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainActivityViewModel @Inject constructor (private var movieRepository: MovieRepository)
    :ViewModel(){

       var  responsMovie = MutableLiveData<NetworkResult<List<Movie>>>()

    init {
        viewModelScope.launch {
            movieRepository.getPopularMovies().collect(){
                responsMovie.postValue(it)
            }
        }
    }
    
}