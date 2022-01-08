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
import com.example.proftaakandroid.model.Car
import com.example.proftaakandroid.model.CarItem
import com.example.proftaakandroid.model.CarViewModel

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

        val model: CarViewModel by viewModels()
        model.carResponse.observe(this) {
            binding.result.text = model.carResponse.value
        }

        binding.get.setOnClickListener {
            model.getCars()
        }

        binding.delete.setOnClickListener {
            model.deleteCar(4)
        }

        binding.post.setOnClickListener {
            model.postCarIce(Car(owner = null, tco = 21, fuelType = FuelType.GAS, costsPerKM = 12, model = "Ja graag", id = 5, picture = "hallo"))
        }
    }
}

internal fun Fragment.navigate(@IdRes action: Int) = findNavController().navigate(action)