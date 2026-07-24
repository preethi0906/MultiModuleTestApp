package com.example.domain.repository

import com.example.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    fun getUser(id: String): Flow<User?>
    suspend fun fetchAndSaveUser(id: String)
    suspend fun updateProfile(user: User)
}
