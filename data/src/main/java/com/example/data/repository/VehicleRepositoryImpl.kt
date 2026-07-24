package com.example.data.repository

import com.example.domain.model.Vehicle
import com.example.domain.repository.VehicleRepository
import com.example.data.remote.VehicleRemoteDataSource
import com.example.data.local.VehicleLocalDataSource

class VehicleRepositoryImpl(
    private val remoteDataSource: VehicleRemoteDataSource,
    private val localDataSource: VehicleLocalDataSource
) : VehicleRepository {
    override suspend fun getVehicles(): List<Vehicle> {
        // Implement logic using data sources
        return emptyList()
    }
}
