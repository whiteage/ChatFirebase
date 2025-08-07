package com.example.chatfirebase

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.ViewModelProvider
import com.example.chatfirebase.presentation.navigation.Navig
import com.example.chatfirebase.presentation.screens.RegisterScreen
import com.example.chatfirebase.presentation.viewmodel.MainVM
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel = ViewModelProvider(this)[MainVM::class.java]
        enableEdgeToEdge()
        setContent {
            Navig(viewModel)
        }
    }
}

