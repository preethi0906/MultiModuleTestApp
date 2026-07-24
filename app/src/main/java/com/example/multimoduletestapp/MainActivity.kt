package com.example.multimoduletestapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.data.di.RepositoryModule
import com.example.domain.usecase.GetUserUseCase
import com.example.feature_home.HomeScreen
import com.example.feature_home.HomeViewModel
import com.example.multimoduletestapp.ui.theme.MultiModuleTestAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        
        // 1. Manual Dependency Injection setup
        // The ':app' module wires ':data' implementations to ':domain' interfaces
        val userRepository = RepositoryModule.provideUserRepository(this)
        val getUserUseCase = GetUserUseCase(userRepository)
        
        setContent {
            MultiModuleTestAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Box(modifier = Modifier.padding(innerPadding)) {
                        
                        // 2. Create the ViewModel using the Factory provided in HomeViewModel
                        val homeViewModel: HomeViewModel = viewModel(
                            factory = HomeViewModel.provideFactory(getUserUseCase)
                        )
                        
                        // 3. Pass the ViewModel to the feature screen
                        HomeScreen(
                            userId = "user_123",
                            viewModel = homeViewModel
                        )
                    }
                }
            }
        }
    }
}
