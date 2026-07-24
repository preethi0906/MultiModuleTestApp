package com.example.domain.usecase

import com.example.domain.repository.UserRepository

class LoginUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(email: String, password: String) {
        // Implement login logic
    }
}
