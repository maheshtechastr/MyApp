package com.mpg.myapp.domain.usecases

import com.mpg.myapp.domain.model.User
import com.mpg.myapp.domain.repository.UserRepository
import javax.inject.Inject

class UserUseCases @Inject constructor(private val repository: UserRepository) {
    fun getUser(email: String?): User? {
        return repository.getUser(email)
    }
    fun isValidUser(email: String?): User? {
        return repository.getUser(email)
    }
    fun getUsers(): List<User> {
        return repository.getUsers()
    }
    fun insertUser(name: String, email: String, mobile: String){
        repository.insertUser(name = name, email = email, mobile = mobile)
    }
    fun deleteUser(email: String){
        repository.deleteUser(email = email)
    }
    fun updateUser(name: String, email: String) {
        repository.updateUser(name = name, email = email)
    }
}