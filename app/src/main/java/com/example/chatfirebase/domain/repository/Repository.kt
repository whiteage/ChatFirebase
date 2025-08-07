package com.example.chatfirebase.domain.repository

import com.example.chatfirebase.domain.entity.AuthStates
import com.example.chatfirebase.domain.usecases.AddNewChatterUseCase

interface Repository {

    suspend fun addNewChatter(email : String)
    suspend fun deleteChatter(email: String)
    suspend fun loadAllMassages()
    suspend fun login(email : String, password : String) : AuthStates
    suspend fun register(email : String, password : String) : AuthStates
    suspend fun sendMassage(massageBody : String)
    suspend fun sendCode(phone : String)

}