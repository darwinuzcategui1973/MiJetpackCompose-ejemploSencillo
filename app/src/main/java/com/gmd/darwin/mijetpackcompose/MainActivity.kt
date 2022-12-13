package com.gmd.darwin.mijetpackcompose

import android.content.res.Resources
import android.content.res.Resources.Theme
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.gmd.darwin.mijetpackcompose.modelo.Movie
import com.gmd.darwin.mijetpackcompose.modelo.Pelicula
import com.gmd.darwin.mijetpackcompose.ui.theme.MiJetpackComposeTheme
import com.gmd.darwin.mijetpackcompose.viewModel.MovieViewModel
import com.gmd.darwin.mijetpackcompose.vistas.MovieItem
// import com.gmd.darwin.mijetpackcompose.vistas.PeliculaItem
import com.gmd.darwin.mijetpackcompose.vistasModelo.PeliculaVistaModelo

class MainActivity : ComponentActivity() {

    private val movieViewModel by viewModels<MovieViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
                // A surface container using the 'background' color from the theme
            Surface(color = MaterialTheme.colors.background) {
                MovieList(movieList = movieViewModel.movieListResponse)
                movieViewModel.getMovieList()

            }
        }
    }
}

@Composable
fun MovieList(movieList: List<Movie>) {
    LazyColumn {
        itemsIndexed(items = movieList) { index, item ->
            MovieItem(movie =  item)
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    MiJetpackComposeTheme {
        val movie = Movie(
            "Coco",
            "https://howtodoandroid.com/images/coco.jpg",
            "Coco is a 2017 American 3D computer-animated musical fantasy adventure film produced by Pixar",
            "Latest"
        )

        MovieItem(movie = movie )


    }
}
