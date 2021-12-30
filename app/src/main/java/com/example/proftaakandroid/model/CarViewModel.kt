package com.example.proftaakandroid.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proftaakandroid.CarApi
import kotlinx.coroutines.launch

private const val TAG = "CarViewModel"

class CarViewModel : ViewModel() {
    private val _carResponse: MutableLiveData<String> = MutableLiveData()

    val carResponse: LiveData<String>
        get() = _carResponse

    init {
        getCarItems()
    }

    fun getCarItems() {
        viewModelScope.launch {
            try {
                _carResponse.value = CarApi.retrofitService.getCars().toString()
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }

    fun deleteCarItem(id: Int) {
        viewModelScope.launch {
            try {
                CarApi.retrofitService.deleteItem(id)
                _carResponse.value = "deleted item $id"
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }

    fun postCarItem(car: Car) {
        viewModelScope.launch {
            try {
                CarApi.retrofitService.postItem(car)
                _carResponse.value = "posted item $car"
            } catch (e: Exception) {
                _carResponse.value = e.message.toString()
            }
        }
    }
}