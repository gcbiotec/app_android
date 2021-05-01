package com.example.businesscontrolv3.viewModel

import android.util.Patterns
import android.view.View
import androidx.databinding.Bindable
import androidx.databinding.Observable
import androidx.databinding.PropertyChangeRegistry
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.businesscontrolv3.model.Result
import com.example.businesscontrollv3.model.Usuario
import com.example.businesscontrolv3.BR
import com.example.businesscontrolv3.model.Login
import com.example.businesscontrolv3.repository.LoginRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class LoginViewModel(val loginRepository: LoginRepository) : ViewModel(), Observable {

    @Bindable
    var email: String = "teste@gmail.com.br"

    @Bindable
    var password: String = ""

    @Bindable
    var loadingVisibility: Int = View.GONE
        set(value) {
            field = value
            notifyPropertyChange(BR.loadingVisibility)
        }

    @Bindable
    var errorMessage: String =""
    set(value) {
        field = value
        notifyPropertyChange(BR.errorMessage)
    }

    var redirect: MutableLiveData<Boolean> = MutableLiveData(false)

    private val callbacks: PropertyChangeRegistry by lazy {
        PropertyChangeRegistry()
    }

    override fun addOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.add(callback)
    }

    override fun removeOnPropertyChangedCallback(callback: Observable.OnPropertyChangedCallback?) {
        callbacks.remove(callback)
    }

    private fun notifyPropertyChange(fieldId: Int) {
        callbacks.notifyCallbacks(this, fieldId, null)

    }
    fun formIsValid():Boolean =
        this.password.isNotBlank() &&
                this.email.isNotBlank() &&
                Patterns.EMAIL_ADDRESS.matcher(this.email).matches()

    fun doLogin() {
        this.loadingVisibility = View.VISIBLE

        // CHECAGEM
        viewModelScope.launch(Dispatchers.IO) {
            val result = loginRepository.login(email, password)

            when(result) {
                is Result.Success<Login> -> redirect.postValue(true)
                is Result.Error -> showError(result.exception.message)
            }

            loadingVisibility = View.GONE
        }
    }

//    fun doLogin() {
//        this.loadingVisibility = View.VISIBLE
//        viewModelScope.launch(Dispatchers.IO) {
//            delay(2000)
//
//            if (email == "teste@gmail.com.br" && password == "admin") {
//                print("Sucess!")
//                redirect.postValue(true)
//            } else {
//                showError("Wrong Password!")
//                redirect.postValue(false)
//
//            }
//            loadingVisibility = View.GONE
//        }
//
//    }
    private fun showError(message: String?){
        this.errorMessage = message?: "Mensagem de erro desconhecido"
    }
}