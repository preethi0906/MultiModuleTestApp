package com.example.data.repository

import com.example.domain.model.User
import com.example.domain.repository.UserRepository
import com.example.data.remote.UserRemoteDataSource
import com.example.data.local.UserLocalDataSource
import com.example.data.mapper.UserMapper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class UserRepositoryImpl(
    private val remoteDataSource: UserRemoteDataSource,
    private val localDataSource: UserLocalDataSource
) : UserRepository {

    override fun getUser(id: String): Flow<User?> {
        return localDataSource.getUser(id).map { entity ->
            entity?.let { UserMapper.mapEntityToDomain(it) }
        }
    }

    override suspend fun fetchAndSaveUser(id: String) {
        try {
            val userDto = remoteDataSource.getUser(id)
            val userEntity = UserMapper.mapDomainToEntity(UserMapper.mapDtoToDomain(userDto))
            localDataSource.saveUser(userEntity)
        } catch (e: Exception) {
            // Handle network errors (e.g., log or throw custom exception)
        }
    }

    override suspend fun updateProfile(user: User) {
        try {
            remoteDataSource.updateProfile(UserMapper.mapDomainToDto(user))
            localDataSource.saveUser(UserMapper.mapDomainToEntity(user))
        } catch (e: Exception) {
            // Handle errors
        }
    }
}
