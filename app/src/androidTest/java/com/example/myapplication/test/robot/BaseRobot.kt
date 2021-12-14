package com.example.myapplication.test.robot

import android.view.ViewGroup
import androidx.test.platform.app.InstrumentationRegistry
import androidx.test.runner.lifecycle.ActivityLifecycleMonitorRegistry
import androidx.test.runner.lifecycle.Stage
import androidx.viewbinding.ViewBinding
import com.example.myapplication.ui.base.BaseActivity
import org.junit.Assert

@Suppress("UNCHECKED_CAST")
open class BaseRobot<A : BaseActivity<*, *>, VB : ViewBinding> {

    fun getActivity(action: (A) -> Unit) {
        InstrumentationRegistry.getInstrumentation().runOnMainSync {
            val activity = ActivityLifecycleMonitorRegistry
                .getInstance()
                .getActivitiesInStage(Stage.RESUMED)
                .elementAtOrNull(0) as? A

            activity?.let { action.invoke(it) }
                ?: run { Assert.fail("Activity not found") }
        }
    }

    fun getActivityViewBinding(action: (VB) -> Unit) {
        getActivity { activity ->
            try {
                val viewBinding = activity.getViewBiding(
                    (activity.findViewById<ViewGroup>(android.R.id.content)).getChildAt(0)
                )
                action.invoke(viewBinding as VB)
            } catch (e: Exception) {
                e.printStackTrace()
                Assert.fail("Activity view binding does not match with root layout")
            }
        }
    }
}
