package com.example.data.repository

import com.example.domain.repository.AuthRepository
import com.example.data.remote.AuthRemoteDataSource

class AuthRepositoryImpl(
    private val remoteDataSource: AuthRemoteDataSource
) : AuthRepository {
    override suspend fun login(email: String, password: String) {
        // Implement logic using remoteDataSource
    }

    override suspend fun logout() {
        // Implement logic
    }
}
