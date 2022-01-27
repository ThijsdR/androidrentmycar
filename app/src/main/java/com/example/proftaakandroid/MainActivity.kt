package com.example.proftaakandroid

import android.os.Bundle
import androidx.activity.viewModels
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.proftaakandroid.constants.FuelType
import com.example.proftaakandroid.databinding.ActivityMainBinding
import com.example.proftaakandroid.model.dataclasses.Car
import com.example.proftaakandroid.model.viewmodels.CarViewModel

class MainActivity : AppCompatActivity() {
    // Binding object instance corresponding to the activity_main.xml layout
    // when the view hierarchy is attached to the fragment.
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        navController = navHostFragment.navController

    }
}

internal fun Fragment.navigate(@IdRes action: Int) = findNavController().navigate(action)