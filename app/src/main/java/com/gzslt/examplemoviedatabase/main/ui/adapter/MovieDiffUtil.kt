package com.gzslt.examplemoviedatabase.main.ui.adapter

import androidx.recyclerview.widget.DiffUtil
import com.gzslt.examplemoviedatabase.main.model.MovieListItemUiModel

object MovieDiffUtil : DiffUtil.ItemCallback<MovieListItemUiModel>() {

    override fun areItemsTheSame(
        oldItem: MovieListItemUiModel,
        newItem: MovieListItemUiModel
    ): Boolean =
        oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: MovieListItemUiModel,
        newItem: MovieListItemUiModel
    ): Boolean =
        oldItem == newItem
}
