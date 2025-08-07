package com.example.chatfirebase.domain.usecases

import com.example.chatfirebase.domain.repository.Repository
import javax.inject.Inject

class LoadAllMassagesUseCase @Inject constructor(private val repo : Repository) {

    suspend fun loadAllMassages() {
        return repo.loadAllMassages()
    }
}