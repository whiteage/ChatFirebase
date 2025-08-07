package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.entity.AuthStates
import com.example.chatfirebase.domain.repository.Repository
import com.google.firebase.auth.AuthResult
import javax.inject.Inject

class LoginUseCase @Inject constructor(private val repo : Repository)  {
    suspend fun login(email : String, password : String) : AuthStates {
        return repo.login(email, password)
    }


}