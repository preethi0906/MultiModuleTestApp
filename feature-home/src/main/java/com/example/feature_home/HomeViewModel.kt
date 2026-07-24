package com.example.feature_home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.User
import com.example.domain.usecase.GetUserUseCase
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.CreationExtras

class HomeViewModel(private val getUserUseCase: GetUserUseCase) : ViewModel() {

    fun user(id: String): StateFlow<User?> = getUserUseCase(id)
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = null
        )

    fun refreshUser(id: String) {
        viewModelScope.launch {
            getUserUseCase.refreshUser(id)
        }
    }

    companion object {
        fun provideFactory(getUserUseCase: GetUserUseCase): ViewModelProvider.Factory = 
            object : ViewModelProvider.Factory {
                @Suppress("UNCHECKED_CAST")
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return HomeViewModel(getUserUseCase) as T
                }
            }
    }
}
