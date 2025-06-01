package com.mpg.myapp.model

import javax.inject.Inject


data class User @Inject constructor(val name: String, val email: String)
