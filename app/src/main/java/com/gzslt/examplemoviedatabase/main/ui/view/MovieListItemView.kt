package com.gzslt.examplemoviedatabase.main.ui.view

import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.widget.FrameLayout
import coil.load
import com.gzslt.examplemoviedatabase.R
import com.gzslt.examplemoviedatabase.common.ui.adapter.BindableBaseRecyclerViewAdapter
import com.gzslt.examplemoviedatabase.databinding.ViewMovieListItemBinding
import com.gzslt.examplemoviedatabase.main.model.MovieListItemUiModel
import com.gzslt.examplemoviedatabase.main.ui.adapter.MovieAdapter

class MovieListItemView :
    FrameLayout,
    BindableBaseRecyclerViewAdapter.Bindable<MovieListItemUiModel> {

    private val binding = ViewMovieListItemBinding.inflate(LayoutInflater.from(context), this)

    var onItemClickListener: MovieAdapter.OnItemClickListener? = null

    constructor(context: Context) : super(context)

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) :
        super(context, attrs, defStyleAttr)

    init {
        layoutParams = LayoutParams(
            LayoutParams.MATCH_PARENT,
            LayoutParams.WRAP_CONTENT,
        )

        val paddingVertical = resources.getDimension(R.dimen.margin_padding_size_tiny).toInt()
        val paddingHorizontal = resources.getDimension(R.dimen.margin_padding_size_small).toInt()
        setPadding(paddingHorizontal, paddingVertical, paddingHorizontal, paddingVertical)
    }

    override fun bind(model: MovieListItemUiModel) {
        with(binding) {
            // TODO use model.imageUrl
            movieImageView.load(R.drawable.test_movie_poster_image) {
                crossfade(true)
            }
            movieTitleTextView.text = model.title
            releaseDateTextView.text = model.releaseDate

            setOnClickListener {
                onItemClickListener?.onItemClicked(model.id)
            }
        }
    }
}
