package com.mpg.myapp.data.mapper

import com.mpg.myapp.data.model.UserEntity
import com.mpg.myapp.domain.model.User

fun UserEntity.toMap() = User(
    name = name,
    email = email,
    mobile = mobile
)

fun List<UserEntity>.toMap() = map { it.toMap() }