package com.example.chatfirebase.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.lifecycle.ViewModel
import androidx.navigation.NavHostController
import com.example.chatfirebase.presentation.entity.ChatCardEntity
import com.example.chatfirebase.presentation.navigation.Screens
import com.example.chatfirebase.presentation.viewmodel.MainVM

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navHostController : NavHostController, viewModel: MainVM) {
    val dummyChats = remember {
        listOf(
            ChatCardEntity(1, "Вася", "Привет!", "10:30", 2),
            ChatCardEntity(2, "Петя", "Как дела?", "Вчера"),
            ChatCardEntity(3, "Коля", "Встречаемся завтра в 8?", "Пн"),
            ChatCardEntity(4, "Маша", "Ок", "Вт"),
            ChatCardEntity(5, "Даша", "Пришли фото", "10:15", 5),
            ChatCardEntity(6, "Анна", "Отлично, спасибо", "20:00", 1),
            ChatCardEntity(7, "Иван", "Завтра", "Сегодня", 3)
        )
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Чат") },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = { /* Действие по нажатию на кнопку */ }) {
                Icon(Icons.Default.Add, contentDescription = "Новый чат")
            }
        }
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            itemsIndexed(items = dummyChats) { _, item ->
                ChatCard(item)
            }
        }
    }




}