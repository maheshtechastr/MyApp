package com.mpg.myapp.data.datasource.db

import com.mpg.myapp.data.model.UserEntity
import jakarta.inject.Inject

class UserDataSource @Inject constructor(private val userDao: UserDao) {
    fun getUser(email: String?): UserEntity? {
        return userDao.getUser(email)
    }
    fun isValidUser(email: String?): UserEntity? {
        return userDao.getUser(email)
    }
    fun getUsers(): List<UserEntity> {
        return userDao.getUsers().orEmpty()
    }
    fun insertUser(name: String, email: String, mobile: String){
        userDao.insertUser(name = name, email = email, mobile = mobile)
    }
    fun deleteUser(email: String){
        userDao.deleteUser(email = email)
    }
    fun updateUser(name: String, email: String) {
        userDao.updateUser(name = name, email = email)
    }
}