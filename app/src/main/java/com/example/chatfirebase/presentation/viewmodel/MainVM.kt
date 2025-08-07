package com.example.chatfirebase.presentation.viewmodel


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.chatfirebase.data.RepositoryImpl
import com.example.chatfirebase.domain.entity.AuthStates
import com.example.chatfirebase.domain.usecases.AddNewChatterUseCase
import com.example.chatfirebase.domain.usecases.DeleteChatterUseCase
import com.example.chatfirebase.domain.usecases.LoadAllMassagesUseCase
import com.example.chatfirebase.domain.usecases.LoginUseCase
import com.example.chatfirebase.domain.usecases.RegisterUseCase
import com.example.chatfirebase.domain.usecases.SendCodeUseCase
import com.example.chatfirebase.domain.usecases.SendMassageUseCase
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainVM @Inject constructor(
    private val addNewChatter : AddNewChatterUseCase,
    private val deleteChatter: DeleteChatterUseCase,
    private val loadAllMassages : LoadAllMassagesUseCase,
    private val login: LoginUseCase,
    private val register: RegisterUseCase,
    private val sendMassage: SendMassageUseCase,
    private val sendCode: SendCodeUseCase
) : ViewModel() {


    val _state = MutableStateFlow<AuthStates?>(null)
    val state : MutableStateFlow<AuthStates?> = _state

    init {
        checkAuth()
    }

    fun login(email : String, password : String){
        viewModelScope.launch {
            _state.value = AuthStates.Loading
            val result = login.login(email, password)
            _state.value = result
        }
    }
    fun register(email : String, password : String){
        viewModelScope.launch {
            _state.value = AuthStates.Loading
            val result = register.register(email, password)
            _state.value = result
        }
    }

    fun checkAuth(){
        val user = FirebaseAuth.getInstance().currentUser
        _state.value = if(user != null){
            AuthStates.Success(user.uid)
        }
        else{
            AuthStates.Unauthorized
        }
    }



}