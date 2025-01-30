package org.com.testmatemultiplatform.auth

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class LoginViewModel(private val authRepository: AuthRepository) : ViewModel() {
    private val _uiState = MutableStateFlow("")
    val uiState: StateFlow<String> = _uiState

    fun performLogin(username: String, password: String) {
        viewModelScope.launch {
            try {
                val response = authRepository.loginUser(
                    request = LoginRequest(username, password)
                )
                _uiState.value = "Login Successful: Token: ${response.token}"
            } catch (e: Exception) {
                _uiState.value = "Login Failed: ${e.message}"
            }
        }
    }
}
