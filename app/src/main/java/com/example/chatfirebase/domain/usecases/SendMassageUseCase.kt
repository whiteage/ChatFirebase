package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.repository.Repository
import javax.inject.Inject

class SendMassageUseCase @Inject constructor(private val repo : Repository) {
    suspend fun sendMassage(massageBody : String){
        return repo.sendMassage(massageBody)
    }
}