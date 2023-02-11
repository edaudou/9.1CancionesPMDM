package com.example.a91canciones.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [Cancion::class], version = 1)
abstract class CancionDatabase: RoomDatabase() {
    abstract fun cancionDatabaseDao(): CancionDatabaseDao
    companion object {
        @Volatile
        private var INSTANCE: CancionDatabase? = null

        fun getInstance(context: Context): CancionDatabase{
            return INSTANCE?: synchronized(this){
                Room.databaseBuilder(
                    context.applicationContext,
                    CancionDatabase::class.java,
                    "cancion_database").build()
            }
        }

    }
}


