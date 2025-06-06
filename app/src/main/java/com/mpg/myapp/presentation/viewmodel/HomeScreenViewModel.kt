package com.mpg.myapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import com.mpg.myapp.domain.usecases.UserUseCases
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val userUseCases: UserUseCases) :
    ViewModel() {
    private val _username = MutableStateFlow("")

    //    private val _user = MutableStateFlow(User("", "", ""))
    val username: StateFlow<String> = _username

    init {
        userUseCases.insertUser(
            name = "Mahesh",
            email = "mahesh.prasadgupta@tcs.com",
            mobile = "8010211159"
        )
    }

    fun updateUsername(newValue: String) {
        _username.value = newValue
    }

    private val _toastMessage = MutableStateFlow("")
    val toastMessage: StateFlow<String> = _toastMessage
    fun showToastMessage(input: String) {
        _toastMessage.value = "Hello, $input! ${userUseCases.getUser("mahesh.prasadgupta@tcs.com")} "
    }
}
