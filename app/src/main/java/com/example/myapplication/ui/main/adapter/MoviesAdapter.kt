package com.example.myapplication.ui.main.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.ItemMovieBinding
import com.example.myapplication.domain.entity.Movie
import com.squareup.picasso.Picasso

class MoviesAdapter : ListAdapter<Movie, MoviesAdapter.MoviesViewHolder>(DIFF_CALLBACK) {

    private var onItemClick: ((Movie) -> Unit)? = null
    fun setOnItemClickListener(onItemClick: (Movie) -> Unit) {
        this.onItemClick = onItemClick
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MoviesViewHolder(
        ItemMovieBinding.inflate(
            LayoutInflater.from(parent.context),
            parent, false
        )
    )

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        holder.bind(getItem(position))
    }

    inner class MoviesViewHolder(
        private val itemBinding: ItemMovieBinding
    ) : RecyclerView.ViewHolder(itemBinding.root) {
        fun bind(data: Movie) {
            itemBinding.apply {
                root.setOnClickListener { onItemClick?.invoke(data) }
                tvTitle.text = data.title
                tvDescription.text = data.description
                Picasso.get()
                    .load(data.poster.replace("http://", "https://"))
                    .fit()
                    .into(ivMovieCover)
            }
        }
    }

    companion object {
        private val DIFF_CALLBACK = object : DiffUtil.ItemCallback<Movie>() {
            override fun areItemsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem.title == newItem.title
            }

            override fun areContentsTheSame(
                oldItem: Movie,
                newItem: Movie
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}
