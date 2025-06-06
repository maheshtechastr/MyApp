package com.mpg.myapp.data.datasource.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.mpg.myapp.data.model.UserEntity

@Database(
    entities = [UserEntity::class],
    version = 1,
    exportSchema = false
)
abstract class InventoryDatabase : RoomDatabase() {
    abstract fun inventoryDao(): UserDao
}