package com.mpg.myapp.data.repository

import com.mpg.myapp.data.datasource.db.UserDataSource
import com.mpg.myapp.data.mapper.toMap
import com.mpg.myapp.domain.repository.UserRepository
import com.mpg.myapp.data.model.UserEntity
import com.mpg.myapp.domain.model.User
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(private val dataSource: UserDataSource) : UserRepository {
    override fun getUser(email: String?): User? {
        return dataSource.getUser(email)?.toMap()
    }

    override fun isValidUser(email: String?): User? {
       return dataSource.isValidUser(email)?.toMap()
    }

    override fun getUsers(): List<User> {
        return dataSource.getUsers().toMap()
    }

    override fun insertUser(name: String, email: String, mobile: String) {
        dataSource.insertUser(name = name, email = email, mobile = mobile)
    }

    override fun deleteUser(email: String) {
        dataSource.deleteUser(email = email)
    }

    override fun updateUser(name: String, email: String) {
        dataSource.updateUser(name = name, email = email)
    }
}