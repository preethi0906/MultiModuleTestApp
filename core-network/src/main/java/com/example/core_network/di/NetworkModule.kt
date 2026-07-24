package com.example.core_network.di

import com.example.core_network.api.AuthApi
import com.example.core_network.api.UserApi
import com.example.core_network.api.VehicleApi
import com.example.core_network.network.OkHttpProvider
import com.example.core_network.network.RetrofitProvider
import retrofit2.Retrofit

object NetworkModule {
    private val retrofit: Retrofit by lazy {
        RetrofitProvider.provideRetrofit(OkHttpProvider.provideOkHttpClient())
    }

    fun provideUserApi(): UserApi = retrofit.create(UserApi::class.java)
    fun provideVehicleApi(): VehicleApi = retrofit.create(VehicleApi::class.java)
    fun provideAuthApi(): AuthApi = retrofit.create(AuthApi::class.java)
}
