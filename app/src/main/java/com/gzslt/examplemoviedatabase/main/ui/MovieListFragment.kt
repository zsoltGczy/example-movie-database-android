package com.gzslt.examplemoviedatabase.main.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.gzslt.examplemoviedatabase.common.extension.setOnActionSearch
import com.gzslt.examplemoviedatabase.databinding.FragmentMovieListBinding
import com.gzslt.examplemoviedatabase.main.model.MovieListItemUiModel
import com.gzslt.examplemoviedatabase.main.ui.adapter.MovieAdapter

class MovieListFragment : BaseFragment() {

    private lateinit var movieAdapter: MovieAdapter

    private var _binding: FragmentMovieListBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        _binding = FragmentMovieListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        movieAdapter = MovieAdapter(getMainActivity()).apply {
            onItemClickListener = object : MovieAdapter.OnItemClickListener {
                override fun onItemClicked(movieId: Long) {
                    // TODO navigate to details screen with args
                }
            }
        }

        with(binding) {
            searchTextInputEditText.setOnActionSearch { text ->
                // TODO
            }

            with(movieRecyclerView) {
                layoutManager = LinearLayoutManager(getMainActivity())
                adapter = movieAdapter
            }
        }
    }

    override fun onResume() {
        super.onResume()

        // TODO get movie list from viewModel
        movieAdapter.submitList(testList)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        private val testList = listOf(
            MovieListItemUiModel(
                id = 1L,
                title = "The King's Man",
                releaseDate = "2021",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aq4Pwv5Xeuvj6HZKtxyd23e6bE9.jpg"
            ),
            MovieListItemUiModel(
                id = 2L,
                title = "Spider-Man: No Way Home",
                releaseDate = "2021",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            ),
            MovieListItemUiModel(
                id = 3L,
                title = "Doctor Strange in the Multiverse of Madness",
                releaseDate = "2022",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/byYRjzd9epz1F9yG3hpDWn9zeIx.jpg"
            ),
            MovieListItemUiModel(
                id = 1L,
                title = "The King's Man",
                releaseDate = "2021",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/aq4Pwv5Xeuvj6HZKtxyd23e6bE9.jpg"
            ),
            MovieListItemUiModel(
                id = 2L,
                title = "Spider-Man: No Way Home",
                releaseDate = "2021",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/1g0dhYtq4irTY1GPXvft6k4YLjm.jpg"
            ),
            MovieListItemUiModel(
                id = 3L,
                title = "Doctor Strange in the Multiverse of Madness",
                releaseDate = "2022",
                imageUrl = "https://www.themoviedb.org/t/p/w600_and_h900_bestv2/byYRjzd9epz1F9yG3hpDWn9zeIx.jpg"
            ),
        )
    }
}
