package com.example.core_network.api

import com.example.core_network.dto.UserDto
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PUT
import retrofit2.http.Path

interface UserApi {
    @GET("users/{id}")
    suspend fun getUser(@Path("id") id: String): UserDto

    @PUT("users/profile")
    suspend fun updateProfile(@Body user: UserDto)
}
