package com.example.domain.usecase

import com.example.domain.model.User
import com.example.domain.repository.UserRepository

class UpdateProfileUseCase(private val userRepository: UserRepository) {
    suspend operator fun invoke(user: User) {
        userRepository.updateProfile(user)
    }
}
