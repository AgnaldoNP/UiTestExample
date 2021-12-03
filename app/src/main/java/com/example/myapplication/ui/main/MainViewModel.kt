package com.example.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.commom.SingleLiveEvent
import com.example.myapplication.domain.entity.Movie
import com.example.myapplication.domain.usecase.MoviesUseCase
import com.example.myapplication.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val moviesUseCase: MoviesUseCase
) : BaseViewModel() {

    private val _moviesLiveEvent = SingleLiveEvent<List<Pair<String, List<Movie>>>>()
    val moviesLiveEvent: LiveData<List<Pair<String, List<Movie>>>> = _moviesLiveEvent

    fun getMovies() {
        viewModelScope.launch {
            val movies = moviesUseCase.search()
            _moviesLiveEvent.postValue(movies)
        }
    }
}
