package com.mpg.myapp.di


import android.app.Application
import androidx.room.Room
import com.mpg.myapp.data.datasource.db.InventoryDatabase
import com.mpg.myapp.data.datasource.db.UserDao
import com.mpg.myapp.data.datasource.db.UserDataSource
import com.mpg.myapp.data.repository.UserRepositoryImpl
import com.mpg.myapp.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class HomeModule {

    /*
     * The method returns the Database object
     * */
    @Provides
    @Singleton
    fun provideDatabase(applicationContext: Application): InventoryDatabase {
        return Room.databaseBuilder(
            applicationContext, InventoryDatabase::class.java, "InventoryDatabase.db"
        ).allowMainThreadQueries().build()
    }


    /*
     * We need the InventoryDao module.
     * For this, We need the InventoryDatabase object
     * So we will define the providers for this here in this module.
     * */
    @Provides
    @Singleton
    fun provideInventoryDao(inventoryDatabase: InventoryDatabase): UserDao {
            return inventoryDatabase.inventoryDao()
    }

    @Provides
    @Singleton
    fun provideUserDataSource(userDao: UserDao): UserDataSource {
        return UserDataSource(userDao)
    }
    @Singleton
    @Provides
    fun provideUserRepository(userDataSource: UserDataSource): UserRepository {
        return UserRepositoryImpl(userDataSource)
    }
}
