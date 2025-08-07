package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.entity.AuthStates
import com.example.chatfirebase.domain.repository.Repository
import javax.inject.Inject

class RegisterUseCase @Inject constructor(private val repo : Repository) {
    suspend fun register(email : String, password : String) : AuthStates {
        return repo.register(email, password)
    }
}