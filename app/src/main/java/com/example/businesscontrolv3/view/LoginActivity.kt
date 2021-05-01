package com.example.businesscontrolv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import com.example.businesscontrollv3.viewmodel.LoginViewModelFactory
import com.example.businesscontrolv3.R
import com.example.businesscontrolv3.databinding.ActivityLoginBinding
import com.example.businesscontrolv3.repository.LoginRepository
import com.example.businesscontrolv3.viewModel.LoginViewModel
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private val loginViewModel: LoginViewModel by lazy {
        ViewModelProvider(this, LoginViewModelFactory)
            .get(LoginViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_login)
        val binding: ActivityLoginBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_login)

        binding.viewmodel = loginViewModel

        this.redirectToMainActivity()
    }

    fun login(view: View) {
        if (loginViewModel.formIsValid()) {
            loginViewModel.doLogin()
        } else {
            when {
                loginViewModel.password.isBlank() -> PasswordET.error = getString(R.string.password_blank)
                loginViewModel.email.isBlank() -> emailET.error = getString(R.string.email_blank)
                else -> emailET.error = getString(R.string.email_invalid)
            }
        }
    }

    fun redirectToMainActivity() {
        this.loginViewModel.redirect.observe(this) {
            if (it) {
                val mainIntent = Intent(this, MainActivity::class.java)
                startActivity(mainIntent)
            }

        }
    }
}
//   fun enviarNomeParaNextView(view : View){

//        this.nameET = findViewById(R.id.NameET)
//        this.yourNameIsTV = findViewById(R.id.yourNameIs)
//        val valorEditText = nameET.text
//        this.yourNameIsTV.text = getString(R.string.o_seu_nome, valorEditText)
//        yourNameIsTV.visibility = View.VISIBLE

//        val intent = Intent(applicationContext, MainActivity::class.java)

//        startActivity(intent)
//    }
