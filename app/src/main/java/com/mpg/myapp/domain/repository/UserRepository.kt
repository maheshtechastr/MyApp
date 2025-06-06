package com.mpg.myapp.domain.repository

import com.mpg.myapp.domain.model.User

interface UserRepository {
    fun getUser(email: String?): User?
    fun isValidUser(email: String?): User?
    fun getUsers(): List<User>
    fun insertUser(name: String, email: String, mobile: String)
    fun deleteUser(email: String)
    fun updateUser(name: String, email: String)
}