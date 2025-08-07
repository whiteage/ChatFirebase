package com.example.chatfirebase.presentation.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.chatfirebase.domain.entity.AuthStates
import com.example.chatfirebase.presentation.screens.ChatCard
import com.example.chatfirebase.presentation.screens.DialogScreen
import com.example.chatfirebase.presentation.screens.LoginScreen
import com.example.chatfirebase.presentation.screens.MainScreen
import com.example.chatfirebase.presentation.screens.RegisterScreen
import com.example.chatfirebase.presentation.viewmodel.MainVM

@Composable
fun Navig(viewModel: MainVM) {

    val state = viewModel.state.collectAsState()

    val navHostController = rememberNavController()

    val startDestination = when (state.value) {
        is AuthStates.Success -> Screens.MainScreen.route
        is AuthStates.Unauthorized -> Screens.RegistrationScreen.route
        else -> null // Например, пока идёт загрузка
    }

    if (startDestination != null) {
        NavHost(navController = navHostController, startDestination = startDestination) {

            composable(Screens.MainScreen.route) {
                MainScreen(navHostController, viewModel)
            }
            composable(Screens.LoginScreen.route) {
                LoginScreen(navHostController, viewModel)
            }
            composable(Screens.RegistrationScreen.route) {
                RegisterScreen(navHostController, viewModel)
            }
            composable(Screens.DaialogScreen.route) {
                DialogScreen()
            }
        }

    } else {
        Box(
            modifier = Modifier.fillMaxSize(),
            contentAlignment = Alignment.Center
        ) {
            CircularProgressIndicator()
        }
    }



}