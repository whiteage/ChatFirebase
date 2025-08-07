package com.example.chatfirebase.presentation.entity

data class ChatCardEntity(
    val id: Int,
    val name: String,
    val lastMessage: String,
    val time: String,
    val unreadCount: Int = 0,
    val avatarUrl: String = ""
)