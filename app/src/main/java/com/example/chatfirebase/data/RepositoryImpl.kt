package com.example.chatfirebase.data

import com.example.chatfirebase.domain.entity.AuthStates
import com.example.chatfirebase.domain.repository.Repository
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class RepositoryImpl @Inject constructor(): Repository {

    private val auth = FirebaseAuth.getInstance()


    override suspend fun addNewChatter(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteChatter(email: String) {
        TODO("Not yet implemented")
    }

    override suspend fun loadAllMassages() {
        TODO("Not yet implemented")
    }

    override suspend fun login(email: String, password: String) : AuthStates {
        return try {
            val result = auth.signInWithEmailAndPassword(email, password).await()
            AuthStates.Success(result.user?.uid ?:"")
        }
        catch (e : Exception){
            AuthStates.Failed(e.message ?: "Ошибка входа")
        }
    }

    override suspend fun register(email: String, password: String) : AuthStates {
        return try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            AuthStates.Success(result.user?.uid ?: "")
        } catch (e: Exception) {
            AuthStates.Failed(e.message ?: "Ошибка регистрации")
        }
    }

    override suspend fun sendMassage(massageBody: String) {
        TODO("Not yet implemented")
    }

    override suspend fun sendCode(phone: String) {
        TODO("Not yet implemented")
    }
}