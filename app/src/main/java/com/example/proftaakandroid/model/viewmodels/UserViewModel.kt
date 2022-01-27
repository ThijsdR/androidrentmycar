package com.example.proftaakandroid.model.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proftaakandroid.model.dataclasses.User
import com.example.proftaakandroid.services.UserApi
import kotlinx.coroutines.launch

private const val TAG = "UserViewModel"

class UserViewModel : ViewModel() {
    private val _userResponse: MutableLiveData<String> = MutableLiveData()

    val userResponse: LiveData<String>
        get() = _userResponse

    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch {
            try {
                _userResponse.value = UserApi.retrofitService.getUsers().toString()
            } catch (e: Exception) {
                _userResponse.value = e.message.toString()
            }
        }
    }

    fun getUser(id: Int) {
        viewModelScope.launch {
            try {
                _userResponse.value = UserApi.retrofitService.getUser(id).toString()
            } catch (e: Exception) {
                _userResponse.value = e.message.toString()
            }
        }
    }

    fun deleteUser(id: Int) {
        viewModelScope.launch {
            try {
                UserApi.retrofitService.deleteUser(id)
                _userResponse.value = "deleted item $id"
            } catch (e: Exception) {
                _userResponse.value = e.message.toString()
            }
        }
    }

    fun postUser(user: User) {
        viewModelScope.launch {
            try {
                UserApi.retrofitService.postUser(user)
                _userResponse.value = "posted item $user"
            } catch (e: Exception) {
                _userResponse.value = e.message.toString()
            }
        }
    }
}