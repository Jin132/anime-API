package com.example.animeapi.network;

import com.example.animeapi.model.Anime
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {

    @GET("anime/{id}")
    suspend fun getAnimeById(@Path("id") id: String) : Response<Anime>

    @GET("quotes/anime")
    suspend fun getAnimeByName(@Query("title") name: String) : Response<List<Anime>>

    @GET("quotes")
    suspend fun getListOf20AnimeByPopularity() : Response<List<Anime>>



    companion object {
        const val API_URL = "https://animechan.vercel.app/api/"

        fun instance() = Retrofit.Builder()
            .baseUrl(API_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ApiService::class.java)
    }
}

//TODO Поменять картинку,посмотреть название как можно пофиксить,переименовать кнопки