package com.example.data.mapper

import com.example.core_database.entity.UserEntity
import com.example.core_network.dto.UserDto
import com.example.domain.model.User

object UserMapper {
    fun mapDtoToDomain(dto: UserDto): User {
        return User(
            id = dto.id,
            name = dto.name,
            email = dto.email
        )
    }

    fun mapEntityToDomain(entity: UserEntity): User {
        return User(
            id = entity.id,
            name = entity.name,
            email = entity.email
        )
    }

    fun mapDomainToEntity(domain: User): UserEntity {
        return UserEntity(
            id = domain.id,
            name = domain.name,
            email = domain.email
        )
    }

    fun mapDomainToDto(domain: User): UserDto {
        return UserDto(
            id = domain.id,
            name = domain.name,
            email = domain.email
        )
    }
}
