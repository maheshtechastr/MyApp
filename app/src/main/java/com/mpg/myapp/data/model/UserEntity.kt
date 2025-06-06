package com.mpg.myapp.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "user")
data class UserEntity(val name: String, @PrimaryKey val email: String, val mobile: String)
