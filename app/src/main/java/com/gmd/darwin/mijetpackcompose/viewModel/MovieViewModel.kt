package com.gmd.darwin.mijetpackcompose.viewModel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmd.darwin.mijetpackcompose.modelo.Movie
import com.gmd.darwin.mijetpackcompose.servicios.ApiServicio
import kotlinx.coroutines.launch

class MovieViewModel : ViewModel() {

    var movieListResponse:List<Movie> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("")
    fun getMovieList() {
        viewModelScope.launch {
            val apiService = ApiServicio.getInstance()
            try {
                val movieList = apiService.getPeliculas()
                movieListResponse = movieList
            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}
