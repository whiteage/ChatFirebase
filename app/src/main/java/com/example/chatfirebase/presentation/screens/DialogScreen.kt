package com.example.chatfirebase.presentation.screens

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable

import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import com.example.chatfirebase.presentation.entity.DialogCardEntity


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DialogScreen() {
    val dummyChats = listOf(
        DialogCardEntity("Привет", "12:00", false, "Вася"),
        DialogCardEntity("Как дела?", "12:01", true)
    )
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "Васян", textAlign = TextAlign.Center) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer
                )
            )
        },
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            itemsIndexed(items = dummyChats) { _, item ->
                BubbleScreen(item = item)
            }
        }
    }


}