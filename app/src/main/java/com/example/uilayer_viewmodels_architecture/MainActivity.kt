package com.example.uilayer_viewmodels_architecture

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import androidx.customview.widget.Openable
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.navGraphViewModels
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.example.uilayer_viewmodels_architecture.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {


    lateinit var binding: ActivityMainBinding

   lateinit var navController : NavController


    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.fragment_container_view) as NavHostFragment
         navController = navHostFragment.navController

        val navgraphViewModelStoreOwner= navController.getViewModelStoreOwner(R.id.nav_graph)
        val myViewmodel =  ViewModelProvider(navgraphViewModelStoreOwner).get(MyViewModel::class.java)

        NavigationUI.setupWithNavController(binding.toolbar,navController, AppBarConfiguration(navController.graph))


        NavController.OnDestinationChangedListener { controller, destination, arguments ->

            myViewmodel._uiState.value = navController.currentDestination?.displayName.toString()

        }





    }
}