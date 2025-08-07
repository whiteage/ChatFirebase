package com.example.chatfirebase.presentation.navigation



sealed class Screens(val route: String) {
    object RegistrationScreen : Screens("RegistrationScreen")
    object LoginScreen : Screens("LoginScreen")
    object MainScreen : Screens("MainScreen")
    object ChatCard : Screens("ChatCard")
    object MasssangerCard : Screens("MasssangerCard")
    object DaialogScreen : Screens("DaialogScreen")
}