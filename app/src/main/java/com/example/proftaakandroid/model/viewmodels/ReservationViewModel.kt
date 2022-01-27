package com.example.proftaakandroid.model.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proftaakandroid.model.dataclasses.Reservation
import com.example.proftaakandroid.services.ReservationApi
import kotlinx.coroutines.launch

private const val TAG = "ReservationViewModel"

class ReservationViewModel : ViewModel() {
    private val _reservationResponse: MutableLiveData<String> = MutableLiveData()

    val reservationResponse: LiveData<String>
        get() = _reservationResponse

    init {
        getReservations()
    }

    fun getReservations() {
        viewModelScope.launch {
            try {
                _reservationResponse.value = ReservationApi.retrofitService.getReservations().toString()
            } catch (e: Exception) {
                _reservationResponse.value = e.message.toString()
            }
        }
    }

    fun getReservation(id: Int) {
        viewModelScope.launch {
            try {
                _reservationResponse.value = ReservationApi.retrofitService.getReservation(id).toString()
            } catch (e: Exception) {
                _reservationResponse.value = e.message.toString()
            }
        }
    }

    fun deleteReservation(id: Int) {
        viewModelScope.launch {
            try {
                ReservationApi.retrofitService.deleteReservation(id)
                _reservationResponse.value = "deleted item $id"
            } catch (e: Exception) {
                _reservationResponse.value = e.message.toString()
            }
        }
    }

    fun postReservation(reservation: Reservation) {
        viewModelScope.launch {
            try {
                ReservationApi.retrofitService.postReservation(reservation)
                _reservationResponse.value = "posted item $reservation"
            } catch (e: Exception) {
                _reservationResponse.value = e.message.toString()
            }
        }
    }
}