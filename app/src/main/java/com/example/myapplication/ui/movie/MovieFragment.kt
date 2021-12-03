package com.example.myapplication.ui.movie

import android.view.View
import com.example.myapplication.databinding.FragmentMovieBinding
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.EmptyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment<FragmentMovieBinding, EmptyViewModel>() {

    override val viewModel: EmptyViewModel by viewModel()
    override fun inflateRoot(): View = FragmentMovieBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = FragmentMovieBinding.bind(view)

    override fun initUI(viewBinding: FragmentMovieBinding) {
        super.initUI(viewBinding)
    }
}
