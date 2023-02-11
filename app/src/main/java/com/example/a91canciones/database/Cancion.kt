package com.example.a91canciones.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cancion_data")
data class Cancion(


    @ColumnInfo(name = "title")
    val title: String,

    @ColumnInfo(name = "artist")
    var artist:String,

    @ColumnInfo(name = "album")
    var album:String,

    @ColumnInfo(name= "year")
    var year: Int,

    @PrimaryKey(autoGenerate = true)
    //@ColumnInfo(name = "id")
    var id:Long=0L,
)