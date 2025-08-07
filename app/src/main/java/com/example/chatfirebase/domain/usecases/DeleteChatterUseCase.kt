package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.repository.Repository
import javax.inject.Inject

class DeleteChatterUseCase @Inject constructor(private val repo : Repository) {

    suspend fun deleteChatter(email : String){
        return repo.deleteChatter(email)
    }
}