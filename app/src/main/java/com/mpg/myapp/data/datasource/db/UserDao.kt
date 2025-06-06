package com.mpg.myapp.data.datasource.db

import androidx.room.Dao
import androidx.room.Query
import com.mpg.myapp.data.model.UserEntity

@Dao
interface UserDao {
    @Query("SELECT * FROM user WHERE email = :email")
    fun getUser(email: String?): UserEntity?

    @Query("SELECT * FROM user")
    fun getUsers(): MutableList<UserEntity>?

    @Query("insert into user (name, email, mobile) values (:name, :email, :mobile)")
    fun insertUser(name: String, email: String, mobile: String)

    @Query("delete from user where email = :email")
    fun deleteUser(email: String)

    @Query("update user set name = :name where email = :email")
    fun updateUser(name: String, email: String)
}