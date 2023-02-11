package com.example.a91canciones.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.a91canciones.database.Cancion
import com.example.a91canciones.database.CancionDatabase
import com.example.a91canciones.database.CancionDatabaseDao
import kotlinx.coroutines.launch

class CancionViewModel(application: Application):AndroidViewModel(application) {
    private val database:CancionDatabaseDao=CancionDatabase.getInstance(application).cancionDatabaseDao()
    val mAllSongs=database.getAllSongs()

    fun insertCancion(cancion: Cancion){
        viewModelScope.launch {
            database.insert(cancion)
        }
    }

    fun deleteCancion(cancion: Cancion){
        viewModelScope.launch {
            database.clear()
        }
    }

    fun deleteAllSongs(){
        viewModelScope.launch {
            database.clear()
        }
    }
}