package com.example.myapplication.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.example.myapplication.commom.SingleLiveEvent
import com.example.myapplication.domain.entity.Movie
import com.example.myapplication.domain.usecase.MoviesUseCase
import com.example.myapplication.domain.usecase.UserUseCase
import com.example.myapplication.ui.base.BaseViewModel
import kotlinx.coroutines.launch

class MainViewModel(
    private val moviesUseCase: MoviesUseCase,
    private val userUseCase: UserUseCase
) : BaseViewModel() {

    private val _moviesLiveEvent = SingleLiveEvent<List<Pair<String, List<Movie>>>>()
    val moviesLiveEvent: LiveData<List<Pair<String, List<Movie>>>> = _moviesLiveEvent

    private val _redirectToLogin = SingleLiveEvent<Boolean>()
    val redirectToLogin: LiveData<Boolean> = _redirectToLogin

    fun getMovies() {
        if (!userUseCase.isUserLogged()) {
            _redirectToLogin.postValue(true)
            return
        }

        viewModelScope.launch {
            val movies = moviesUseCase.search()
            _moviesLiveEvent.postValue(movies)
        }
    }
}
