package com.example.a91canciones.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update

@Dao
interface CancionDatabaseDao {
    @Insert
    suspend fun insert(night: Cancion)

    @Update
    suspend fun update(night: Cancion)

    @Query("SELECT * from cancion_data WHERE id = :key")
    suspend fun get(key: Long): Cancion?

    @Query("DELETE FROM cancion_data")
    suspend fun clear()

    //@Query("SELECT * FROM cancion_data ORDER BY cancionId DESC LIMIT 1")
    //suspend fun getTonight(): CancionDatabase?

    @Query("SELECT * FROM cancion_data ORDER BY id DESC")
    fun getAllSongs(): LiveData<List<Cancion>>
}
