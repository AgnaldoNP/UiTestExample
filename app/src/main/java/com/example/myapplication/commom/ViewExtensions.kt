package com.example.myapplication.commom

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.fragment.app.findFragment

fun <F : Fragment> FragmentContainerView.getFragment(callback: (F?) -> Unit) {
    this.post {
        if (this.childCount > 0) {
            for (i in 0 until this.childCount) {
                val child = this.getChildAt(i)
                val fragment = child.findFragment<F>()
                callback.invoke(fragment)
                return@post
            }
            callback.invoke(null)
        } else {
            callback.invoke(null)
        }
    }
}

fun <F : Fragment> FragmentContainerView.getCurrentFragment(callback: (F?) -> Unit) {
    this.post {
        if (this.childCount > 0) {
            val child = this.getChildAt(0)
            val fragment = child.findFragment<F>()
            callback.invoke(fragment)
        } else {
            callback.invoke(null)
        }
    }
}
