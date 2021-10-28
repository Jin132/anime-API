package com.example.animeapi.model
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.Ignore
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "anime")
data class Anime (
    @PrimaryKey()
    var id: Int=0,
    @ColumnInfo(name = "anime")
    var animes: String = "",

    @ColumnInfo(name = "character")
    var character: String = "0",

    @ColumnInfo(name = "image_url")
    var image_url: String = "https://pbs.twimg.com/media/CYdSSyMWcAAliBY.jpg",

    @ColumnInfo(name = "quote")
    var quote: String = ""

   // @ColumnInfo(name = "idDrink")
   // var mal_id: String = "",

   // @ColumnInfo(name = "anime")
   // var title: String = "",

   // @PrimaryKey(autoGenerate = true)
   // var id: Int = 0,

   // @ColumnInfo(name = "character")
   // var synopsis: String = "",

   // @ColumnInfo(name = "score")
   // var score: String = "0",

   // @ColumnInfo(name = "quote")
   // var image_url: String = "",

   // @Ignore
   // @SerializedName("title_japanese") val title_japanese: String = "",

    //@Ignore
    //@SerializedName("drinks") val animeList: List<Anime> = listOf()
)