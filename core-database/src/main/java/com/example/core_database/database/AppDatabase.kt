package com.example.core_database.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.core_database.converter.DateConverter
import com.example.core_database.dao.AuthDao
import com.example.core_database.dao.UserDao
import com.example.core_database.dao.VehicleDao
import com.example.core_database.entity.AuthEntity
import com.example.core_database.entity.UserEntity
import com.example.core_database.entity.VehicleEntity

@Database(
    entities = [UserEntity::class, VehicleEntity::class, AuthEntity::class],
    version = 1,
    exportSchema = false
)
@TypeConverters(DateConverter::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun vehicleDao(): VehicleDao
    abstract fun authDao(): AuthDao
}
