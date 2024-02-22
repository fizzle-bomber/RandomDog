package com.example.basicsandroid.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.basicsandroid.network.RetrofitService
import kotlinx.coroutines.launch

class MainViewModel : ViewModel() {

    companion object {
        const val LOG = "GetDogLog"
    }

    private val _message = MutableLiveData<String>()
    val message: LiveData<String>
        get() = _message

    fun getRandomDog() {
        viewModelScope.launch {
            try {
                val response =
                    RetrofitService.dogService.getDogImage()
                if (response.isSuccessful && response.body() != null) {
                    response.body()?.message?.let {
                        _message.value = it
                        Log.d(LOG, it)
                    }
                } else {
                    Log.d(LOG, "Server Error")
                }
            } catch (exception: Exception) {
                exception.message?.let {
                    Log.d(LOG, it)
                }
            }
        }
    }
}