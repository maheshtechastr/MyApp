package com.mpg.myapp.viewmodel

import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class HomeScreenViewModel: ViewModel() {
    private val _username = MutableStateFlow("")
    val username: StateFlow<String> = _username

    fun updateUsername(newValue: String) {
        _username.value = newValue
    }

    private val _toastMessage = MutableStateFlow("")
    val toastMessage: StateFlow<String> = _toastMessage
    fun showToastMessage(input: String) {
        _toastMessage.value = "Hello, $input!"
    }
}
