package com.example.core_network.api

import com.example.core_network.dto.VehicleDto
import retrofit2.http.GET

interface VehicleApi {
    @GET("vehicles")
    suspend fun getVehicles(): List<VehicleDto>
}
