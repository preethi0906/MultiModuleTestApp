package com.example.core_network.network

import com.example.core_network.interceptor.AuthInterceptor
import com.example.core_network.interceptor.LoggingInterceptor
import okhttp3.OkHttpClient

object OkHttpProvider {
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(AuthInterceptor())
            .addInterceptor(LoggingInterceptor.create())
            .build()
    }
}
