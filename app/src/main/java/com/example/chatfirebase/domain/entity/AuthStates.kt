package com.example.chatfirebase.domain.entity

sealed class AuthStates {

    data class Failed(val massage : String) : AuthStates()
    data class Success(val uInt: String) : AuthStates()
    object  Loading : AuthStates()
    object Unauthorized : AuthStates()

}