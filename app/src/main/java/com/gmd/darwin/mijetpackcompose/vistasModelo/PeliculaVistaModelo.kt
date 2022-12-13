package com.gmd.darwin.mijetpackcompose.vistasModelo

import android.os.Parcel
import android.os.Parcelable
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gmd.darwin.mijetpackcompose.modelo.Pelicula
import com.gmd.darwin.mijetpackcompose.servicios.ApiServicio
import kotlinx.coroutines.launch

class PeliculaVistaModelo() : ViewModel(){
    var peliculaListResponse:List<Pelicula> by mutableStateOf(listOf())
    private var errorMessage: String by mutableStateOf("")
    fun getPeliculaList() {
        viewModelScope.launch {
            val apiServicio = ApiServicio.getInstance()
            try {
                val peliculaList = apiServicio.getPeliculas()
                peliculaListResponse = peliculaList

            }
            catch (e: Exception) {
                errorMessage = e.message.toString()
            }
        }
    }
}