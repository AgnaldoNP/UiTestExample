package com.example.myapplication.ui.base

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner
import androidx.navigation.NavController
import androidx.navigation.NavDestination
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.myapplication.R

abstract class BaseActivity<T : ViewBinding, V : BaseViewModel> :
    AppCompatActivity(),
    NavController.OnDestinationChangedListener {

    abstract val viewModel: V
    abstract fun inflateRoot(): View
    abstract fun getViewBiding(view: View): T

    private val navHostFragment by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as? NavHostFragment
    }

    private val navController by lazy { navHostFragment?.navController }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val root = inflateRoot()
        setContentView(root)

        navController?.addOnDestinationChangedListener(this)
        lifecycle.addObserver(viewModel)
        with(getViewBiding(root)) {
            initUI(this)
            initObservers(this@BaseActivity, this)
        }
        initViewModel(savedInstanceState)
    }

    open fun initViewModel(savedInstanceState: Bundle?) {}
    open fun initUI(viewBinding: T) {}
    open fun initObservers(lifecycleOwner: LifecycleOwner, viewBinding: T) {}

    override fun onDestinationChanged(
        controller: NavController,
        destination: NavDestination,
        arguments: Bundle?
    ) {
    }

    override fun onBackPressed() {
        super.onBackPressed()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun finish() {
        super.finish()
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }

    override fun startActivity(intent: Intent?) {
        super.startActivity(intent)
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out)
    }
}