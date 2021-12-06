package com.example.myapplication.ui.movie

import android.view.View
import androidx.navigation.fragment.navArgs
import com.example.myapplication.databinding.FragmentMovieBinding
import com.example.myapplication.ui.base.BaseFragment
import com.example.myapplication.ui.base.EmptyViewModel
import com.squareup.picasso.Picasso
import org.imaginativeworld.whynotimagecarousel.model.CarouselItem
import org.koin.androidx.viewmodel.ext.android.viewModel

class MovieFragment : BaseFragment<FragmentMovieBinding, EmptyViewModel>() {

    override val viewModel: EmptyViewModel by viewModel()
    override fun inflateRoot(): View = FragmentMovieBinding.inflate(layoutInflater).root
    override fun getViewBiding(view: View) = FragmentMovieBinding.bind(view)

    private val args by navArgs<MovieFragmentArgs>()

    override fun initUI(viewBinding: FragmentMovieBinding) {
        super.initUI(viewBinding)
        requireBaseActivity().applyToolbarNavigationBack()

        val movie = args.movie
        with(viewBinding) {
            tvTitle.text = movie.title
            tvYear.text = movie.year
            tvGenre.text = movie.genre
            tvPlotDescription.text = movie.description
            Picasso.get()
                .load(movie.poster.replace("http://", "https://"))
                .fit()
                .into(ivMovieCover)

            icCarouselImages.addData(
                movie.imagesUrl.map {
                    CarouselItem(it)
                }
            )
        }
    }
}
