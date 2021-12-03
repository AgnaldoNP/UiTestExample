package com.example.myapplication.ui.main.adapter

import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentMoviesBinding
import com.example.myapplication.domain.entity.Movie
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.EmptyViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel

class TabAdapterMoviesFragment(
    private val type: String,
    private val movies: List<Movie>
) : BaseFragment<FragmentMoviesBinding, EmptyViewModel>() {

    override val viewModel: EmptyViewModel by viewModel()
    override fun inflateRoot(): View = FragmentMoviesBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = FragmentMoviesBinding.bind(view)

    private lateinit var moviesAdapter: MoviesAdapter

    fun getTabTitle(): String = type

    override fun initUI(viewBinding: FragmentMoviesBinding) {
        super.initUI(viewBinding)
        moviesAdapter = MoviesAdapter().apply {
            setOnItemClickListener { }
        }
        viewBinding.recyclerView.apply {
            layoutManager = GridLayoutManager(context, 2, RecyclerView.VERTICAL, false)
            setHasFixedSize(true)
            addItemDecoration(MovieItemDecoration(this))
            adapter = moviesAdapter
            post {
                moviesAdapter.submitList(movies)
            }
        }
    }
}
