package com.example.chatfirebase.presentation.entity

data class DialogCardEntity(
    val message: String,
    val time: String,
    val isFromMe: Boolean,
    val senderName: String? = null
)

