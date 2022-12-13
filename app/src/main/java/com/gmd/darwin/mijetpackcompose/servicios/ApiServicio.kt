package com.gmd.darwin.mijetpackcompose.servicios

import android.util.Log
import com.gmd.darwin.mijetpackcompose.modelo.Pelicula
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiServicio {
    //https://howtodoandroid.com/apis/movielist.json
    @GET("movielist.json")
    suspend fun getPeliculas() :List<Pelicula>
    companion object {
        var apiServicio: ApiServicio? =null
        fun  getInstance() : ApiServicio {
            if (apiServicio == null){
                apiServicio = Retrofit.Builder()
                    .baseUrl("https://howtodoandroid.com/apis/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(ApiServicio::class.java)
            }
            Log.d("PASO", apiServicio.toString())
            return apiServicio!!
        }
    }
}