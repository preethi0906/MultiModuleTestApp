package com.example.data.local

import com.example.core_database.dao.UserDao
import com.example.core_database.entity.UserEntity
import kotlinx.coroutines.flow.Flow

class UserLocalDataSource(private val userDao: UserDao) {
    fun getUser(id: String): Flow<UserEntity?> = userDao.getUser(id)
    suspend fun saveUser(user: UserEntity) = userDao.insertUser(user)
}
