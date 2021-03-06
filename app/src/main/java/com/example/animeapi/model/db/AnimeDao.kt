package com.example.animeapi.model.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.animeapi.model.Anime


@Dao
interface AnimeDao {
    @Insert
    fun insert(anime: Anime)

    @Query("SELECT * FROM anime")
    fun getAnimes() : List<Anime>


    @Query("SELECT * FROM anime WHERE id = :id")
    fun getAnimeById(id : Int) : Anime

    @Query("DELETE FROM anime")
    fun deleteAll()

    @Query("DELETE FROM anime WHERE id = :id")
    fun deleteAnimeById(id : Int)

    @Query("SELECT * FROM anime WHERE anime LIKE '%' || :anime || '%'")
    fun getAnimeLikeTitle(anime : String) : List<Anime>

   // @Query("SELECT * FROM anime ORDER BY score desc")
    //fun getAnimeSortedByScore() : List<Anime>
}
