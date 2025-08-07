package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.repository.Repository
import javax.inject.Inject

class AddNewChatterUseCase @Inject constructor(private val repo : Repository) {
    suspend fun addNewChatter(email : String){
        return repo.addNewChatter(email)
    }

}