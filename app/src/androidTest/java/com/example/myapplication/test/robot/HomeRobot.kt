package com.example.myapplication.test.robot

import androidx.test.core.app.ActivityScenario
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.test.di.DiTestManager
import com.example.myapplication.ui.main.MainActivity
import org.koin.java.KoinJavaComponent.inject

class HomeRobot : BaseRobot<MainActivity, ActivityMainBinding>() {

    private val diManager by inject<DiTestManager>(DiTestManager::class.java)

    fun launchMainActivity() {
        ActivityScenario.launch(MainActivity::class.java)
    }

    fun setupKoinMockForHomeLoggedOutTest() {
        diManager.setupKoinMockForHomeLoggedOutTest()
    }
}
