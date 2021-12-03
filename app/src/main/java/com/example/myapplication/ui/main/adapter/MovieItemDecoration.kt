package com.example.myapplication.ui.main.adapter

import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class MovieItemDecoration(
    view: View
) : RecyclerView.ItemDecoration() {

    private val marginHorizontal: Int by lazy {
        view.context.resources.getDimensionPixelSize(R.dimen.margin_small)
    }

    private val marginVertical: Int by lazy {
        view.context.resources.getDimensionPixelSize(R.dimen.margin_small)
    }

    override fun getItemOffsets(
        outRect: Rect,
        view: View,
        parent: RecyclerView,
        state: RecyclerView.State
    ) {
        outRect.apply {
            val position = parent.getChildAdapterPosition(view)
            if (position % 2 == 0) {
                left = marginHorizontal
                right = marginHorizontal / 2
            } else {
                left = marginHorizontal / 2
                right = marginHorizontal
            }

            val lines = ((parent.adapter?.itemCount ?: 0) / 2) + 1
            if (lines == 1) {
                top = marginVertical
                bottom = marginVertical
            } else {
                when (position / 2) {
                    0 -> {
                        top = marginVertical
                        bottom = marginVertical / 2
                    }
                    lines - 1 -> {
                        top = marginVertical / 2
                        bottom = marginVertical
                    }
                    else -> {
                        top = marginVertical / 2
                        bottom = marginVertical / 2
                    }
                }
            }
        }
    }
}
