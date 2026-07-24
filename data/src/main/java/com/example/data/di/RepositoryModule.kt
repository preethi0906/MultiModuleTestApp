package com.example.data.di

import android.content.Context
import com.example.core_database.di.DatabaseModule
import com.example.core_network.di.NetworkModule
import com.example.data.local.UserLocalDataSource
import com.example.data.remote.UserRemoteDataSource
import com.example.data.repository.UserRepositoryImpl
import com.example.domain.repository.UserRepository

object RepositoryModule {
    
    fun provideUserRepository(context: Context): UserRepository {
        val database = DatabaseModule.provideDatabase(context)
        val userDao = DatabaseModule.provideUserDao(database)
        val userApi = NetworkModule.provideUserApi()
        
        return UserRepositoryImpl(
            remoteDataSource = UserRemoteDataSource(userApi),
            localDataSource = UserLocalDataSource(userDao)
        )
    }
}
