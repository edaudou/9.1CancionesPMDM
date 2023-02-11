package com.example.a91canciones

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.a91canciones.database.CancionDatabase
import com.example.a91canciones.database.CancionDatabaseDao
import com.example.a91canciones.databinding.ActivityMainBinding
import com.example.a91canciones.viewmodel.CancionViewModel

class MainActivity : AppCompatActivity() {

    lateinit var cancionDatabaseDao: CancionDatabaseDao
    val cancionViewModel:CancionViewModel by viewModels()
    lateinit var binding:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding=DataBindingUtil.setContentView<ActivityMainBinding>(this,R.layout.activity_main)

        //Change to toolbar
        setSupportActionBar(binding.toolbar)
        val navHostFragment=supportFragmentManager.findFragmentById(R.id.cancion_Fragment) as NavHostFragment
        val navController=navHostFragment.navController

        val appBarConfiguration= AppBarConfiguration(navController.graph)

        binding.toolbar.setupWithNavController(navController,appBarConfiguration)

        cancionDatabaseDao=CancionDatabase.getInstance(applicationContext).cancionDatabaseDao()
    }
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.navmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val toast= Toast.makeText(this, R.string.cleanedData,Toast.LENGTH_SHORT)
        when (item.itemId){

            R.id.action_delete -> {
                toast.show()
                cancionViewModel.deleteAllSongs()

            }
        }
        return true
    }
}