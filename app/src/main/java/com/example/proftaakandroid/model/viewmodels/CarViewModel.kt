package com.example.proftaakandroid.model.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proftaakandroid.model.dataclasses.Car
import com.example.proftaakandroid.services.CarApi
import kotlinx.coroutines.launch

private const val TAG = "CarViewModel"

class CarViewModel : ViewModel() {
    private val _carResponse: MutableLiveData<String> = MutableLiveData()

    val carResponse: LiveData<String>
        get() = _carResponse

    init {
        getCars()
    }

    fun getCars() {
        viewModelScope.launch {
            try {
                _carResponse.value = CarApi.retrofitService.getCars().toString()
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }

    fun getCar(id: Int) {
        viewModelScope.launch {
            try {
                _carResponse.value = CarApi.retrofitService.getCar(id).toString()
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }

    fun deleteCar(id: Int) {
        viewModelScope.launch {
            try {
                CarApi.retrofitService.deleteCar(id)
                _carResponse.value = "deleted item $id"
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }

    fun postCarIce(car: Car) {
        viewModelScope.launch {
            try {
                CarApi.retrofitService.postCarIce(car)
                _carResponse.value = "posted item $car"
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }

    fun postCarEv(car: Car) {
        viewModelScope.launch {
            try {
                CarApi.retrofitService.postCarEv(car)
                _carResponse.value = "posted item $car"
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }
}