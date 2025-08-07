package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.repository.Repository
import javax.inject.Inject

class SendCodeUseCase @Inject constructor(private val repo : Repository) {

    suspend fun sendCode(phoneNumber : String){
        return repo.sendCode(phoneNumber)
    }


}