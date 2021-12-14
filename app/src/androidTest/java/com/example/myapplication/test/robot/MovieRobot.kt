package com.example.myapplication.test.robot

import com.example.myapplication.databinding.FragmentMovieBinding
import com.example.myapplication.test.di.DiTestManager
import com.example.myapplication.ui.movie.MovieFragment
import org.junit.Assert
import org.koin.java.KoinJavaComponent.inject

class MovieRobot : BaseFragmentRobot<MovieFragment, FragmentMovieBinding>() {

    private val diManager by inject<DiTestManager>(DiTestManager::class.java)

    fun assertMovieFragmentOpened() {
        try {
            getCurrentFragment {}
        } catch (e: Exception) {
            e.printStackTrace()
            Assert.fail("MovieFragment is not opened or it is not current fragment")
        }
    }
}
