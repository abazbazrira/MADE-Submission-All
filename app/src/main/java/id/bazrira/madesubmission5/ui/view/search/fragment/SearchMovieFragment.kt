package id.bazrira.madesubmission5.ui.view.search.fragment


import android.content.Context
import android.net.ConnectivityManager
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import id.bazrira.madesubmission5.R
import id.bazrira.madesubmission5.ui.view.movie.adapter.MovieAdapter
import id.bazrira.madesubmission5.ui.viewmodel.MovieViewModel
import kotlinx.android.synthetic.main.fragment_search_movie.*

/**
 * A simple [Fragment] subclass.
 */
class SearchMovieFragment : Fragment() {

    private val API_KEY = "b59545fa485ebb68339cb053f3164aac"

    private lateinit var mainViewModel: MovieViewModel
    private lateinit var adapter: MovieAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_search_movie, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val dataName = SearchMovieFragmentArgs.fromBundle(
            arguments as Bundle
        ).extraName

        rv_movies.setHasFixedSize(true)

        adapter = MovieAdapter()
        adapter.notifyDataSetChanged()

        rv_movies.layoutManager = LinearLayoutManager(context)
        rv_movies.adapter = adapter

        mainViewModel = ViewModelProvider(
            this,
            ViewModelProvider.NewInstanceFactory()
        ).get(MovieViewModel::class.java)

        setViewModel(dataName)

        sw_layout.setOnRefreshListener {
            setViewModel(dataName)
        }
    }

    private fun setViewModel(sName: String) {
        val url = "search/movie?api_key=$API_KEY&language=en-En&query=$sName"

        showLoading(true)

        mainViewModel.setMovie(url)

        mainViewModel.getMovies().observe(viewLifecycleOwner, Observer { items ->
            if (items != null) {
                adapter.setData(items)

                showLoading(false)
            }
        })

        if (sw_layout.isRefreshing && !isNetworkAvailable()) {
            showLoading(false)
            Toast.makeText(context, getString(R.string.failed_to_load_data), Toast.LENGTH_SHORT).show()
        }
    }

    private fun showLoading(state: Boolean) {
        sw_layout.isRefreshing = state
    }

    private fun isNetworkAvailable(): Boolean {
        val connectivityManager =
            activity?.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val activeNetworkInfo = connectivityManager.activeNetworkInfo
        return activeNetworkInfo != null && activeNetworkInfo.isConnected
    }

}
