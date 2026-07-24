package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow

class GetUserUseCase(private val userRepository: UserRepository) {
    operator fun invoke(id: String): Flow<User?> {
        return userRepository.getUser(id)
    }

    suspend fun refreshUser(id: String) {
        userRepository.fetchAndSaveUser(id)
    }
}
