package com.example.businesscontrollv3.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrolv3.repository.LoginRepository
import com.example.businesscontrolv3.viewModel.LoginViewModel

object LoginViewModelFactory : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LoginViewModel::class.java)) {
            val repository = LoginRepository()
            return LoginViewModel(repository) as T
        }

        throw IllegalAccessException("Erro desconhecido")
    }

}