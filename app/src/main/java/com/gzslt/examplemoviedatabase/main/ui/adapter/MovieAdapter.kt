package com.gzslt.examplemoviedatabase.main.ui.adapter

import android.content.Context
import android.view.ViewGroup
import com.gzslt.examplemoviedatabase.common.ui.adapter.BindableBaseRecyclerViewAdapter
import com.gzslt.examplemoviedatabase.common.ui.view.ViewHolder
import com.gzslt.examplemoviedatabase.main.model.MovieListItemUiModel
import com.gzslt.examplemoviedatabase.main.ui.view.MovieListItemView

class MovieAdapter(private val context: Context) :
    BindableBaseRecyclerViewAdapter<MovieListItemUiModel, MovieListItemView>(MovieDiffUtil) {

    init {
        setHasStableIds(true)
    }

    var onItemClickListener: OnItemClickListener? = null

    override fun onCreateItemView(parent: ViewGroup, viewType: Int): MovieListItemView =
        MovieListItemView(context)

    override fun onBindViewHolder(holder: ViewHolder<MovieListItemView>, position: Int) {
        super.onBindViewHolder(holder, position)

        holder.view.onItemClickListener = onItemClickListener
    }

    override fun getItemId(position: Int): Long =
        getItem(position).id

    interface OnItemClickListener {
        fun onItemClicked(movieId: Long)
    }
}
