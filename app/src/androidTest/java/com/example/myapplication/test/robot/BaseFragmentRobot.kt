package com.example.myapplication.test.robot

import android.view.ViewGroup
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.findFragment
import androidx.navigation.fragment.NavHostFragment
import androidx.viewbinding.ViewBinding
import com.example.myapplication.ui.base.BaseActivity
import com.example.myapplication.ui.base.BaseFragment
import org.junit.Assert

@Suppress("UNCHECKED_CAST")
open class BaseFragmentRobot<F : BaseFragment<*, *>, VB : ViewBinding> :
    BaseRobot<BaseActivity<*, *>, VB>() {

    private fun getFragmentContainerView(action: (FragmentContainerView) -> Unit) {
        getActivity { activity ->
            val root = activity.findViewById<ViewGroup>(android.R.id.content)?.getChildAt(0)
            getFragmentContainerView(root as? ViewGroup)
                ?.let { action.invoke(it) }
                ?: run { Assert.fail("Activity ${activity.javaClass.simpleName} does not contain a FragmentContainerView") }
        }
    }

    private fun getFragmentContainerView(container: ViewGroup?): FragmentContainerView? {
        for (i in 0 until (container?.childCount ?: 0)) {
            val view = container?.getChildAt(i)
            if (view is FragmentContainerView) {
                return view
            }

            if (view is ViewGroup) {
                getFragmentContainerView(view)?.let {
                    return@getFragmentContainerView it
                }
            }
        }
        return null
    }

    fun getCurrentFragment(action: (F) -> Unit) {
        getFragmentContainerView { container ->
            try {
                val navHostFragment = container.getChildAt(0).findFragment<NavHostFragment>()
                val fragment = navHostFragment.childFragmentManager.fragments[0] as F
                action.invoke(fragment)
            } catch (e: Exception) {
                e.printStackTrace()
                Assert.fail("Fragment not found")
            }
        }
    }

    fun getCurrentBaseFragmentViewBiding(action: (VB) -> Unit) {
        getCurrentFragment {
            try {
                val viewBinding = it.getViewBiding(it.requireView()) as VB
                action.invoke(viewBinding)
            } catch (e: Exception) {
                e.printStackTrace()
                Assert.fail("Fragment view binding does not match with fragment root layout")
            }
        }
    }
}
