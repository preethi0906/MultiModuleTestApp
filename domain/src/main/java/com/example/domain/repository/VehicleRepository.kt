package com.example.domain.repository

import com.example.domain.model.Vehicle

interface VehicleRepository {
    suspend fun getVehicles(): List<Vehicle>
}
