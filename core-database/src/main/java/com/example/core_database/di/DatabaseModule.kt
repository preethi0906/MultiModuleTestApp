package com.example.core_database.di

import android.content.Context
import androidx.room.Room
import com.example.core_database.database.AppDatabase

object DatabaseModule {
    private var instance: AppDatabase? = null

    fun provideDatabase(context: Context): AppDatabase {
        return instance ?: Room.databaseBuilder(
            context.applicationContext,
            AppDatabase::class.java,
            "app_database"
        ).build().also { instance = it }
    }

    fun provideUserDao(database: AppDatabase) = database.userDao()
    fun provideVehicleDao(database: AppDatabase) = database.vehicleDao()
    fun provideAuthDao(database: AppDatabase) = database.authDao()
}
