package com.example.data.remote

import com.example.core_network.api.UserApi
import com.example.core_network.dto.UserDto

class UserRemoteDataSource(private val userApi: UserApi) {
    suspend fun getUser(id: String): UserDto = userApi.getUser(id)
    suspend fun updateProfile(user: UserDto) = userApi.updateProfile(user)
}
