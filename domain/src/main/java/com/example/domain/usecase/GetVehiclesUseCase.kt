package com.example.domain.usecase

import com.example.domain.model.Vehicle
import com.example.domain.repository.VehicleRepository

class GetVehiclesUseCase(private val vehicleRepository: VehicleRepository) {
    suspend operator fun invoke(): List<Vehicle> {
        return vehicleRepository.getVehicles()
    }
}
