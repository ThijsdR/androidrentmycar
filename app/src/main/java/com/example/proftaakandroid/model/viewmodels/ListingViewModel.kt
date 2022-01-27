package com.example.proftaakandroid.model.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proftaakandroid.model.dataclasses.Listing
import com.example.proftaakandroid.services.ListingApi
import kotlinx.coroutines.launch

private const val TAG = "ListingViewModel"

class ListingViewModel : ViewModel() {
    private val _listingResponse: MutableLiveData<String> = MutableLiveData()

    val listingResponse: LiveData<String>
        get() = _listingResponse

    init {
        getListings()
    }

    fun getListings() {
        viewModelScope.launch {
            try {
                _listingResponse.value = ListingApi.retrofitService.getListings().toString()
            } catch (e: Exception) {
                _listingResponse.value = e.message.toString()
            }
        }
    }

    fun getListing(id: Int) {
        viewModelScope.launch {
            try {
                _listingResponse.value = ListingApi.retrofitService.getListing(id).toString()
            } catch (e: Exception) {
                _listingResponse.value = e.message.toString()
            }
        }
    }

    fun deleteListing(id: Int) {
        viewModelScope.launch {
            try {
                ListingApi.retrofitService.deleteListing(id)
                _listingResponse.value = "deleted item $id"
            } catch (e: Exception) {
                _listingResponse.value = e.message.toString()
            }
        }
    }

    fun postListing(listing: Listing) {
        viewModelScope.launch {
            try {
                ListingApi.retrofitService.postListing(listing)
                _listingResponse.value = "posted item $listing"
            } catch (e: Exception) {
                _listingResponse.value = e.message.toString()
            }
        }
    }
}