package com.example.atherenergy

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import java.util.Date


class MainActivityViewModel : ViewModel() {

    private val _currentDate: MutableLiveData<String> = MutableLiveData()
    val currentDate: LiveData<String> = _currentDate

    init {
        fetchCurrentDate()
    }

    private fun fetchCurrentDate() {
        viewModelScope.launch {
            var currentTimeInMillis = System.currentTimeMillis()
            while (true) {
                _currentDate.postValue(Date(currentTimeInMillis).toString())
                delay(1000)
                currentTimeInMillis += 1000
            }
        }
    }

}