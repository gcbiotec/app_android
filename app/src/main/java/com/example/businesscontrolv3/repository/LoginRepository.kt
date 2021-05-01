package com.example.businesscontrolv3.repository

import com.example.businesscontrolv3.model.Result
import com.example.businesscontrolv3.model.Login
import kotlinx.coroutines.delay
import java.lang.Exception

class LoginRepository {

    suspend fun login(email: String, password: String): Result<Login> {
        return this.simulacaoDeChamadaParaService(email, password)
       }

    private suspend fun simulacaoDeChamadaParaService(email: String, password: String): com.example.businesscontrolv3.model.Result<Login> {
        delay(2000)

        return when(verifyPassword(email, password)) {
            true -> Result.Success(Login(email, password))
            false -> Result.Error(Exception("Email ou senha Invalidos"))
        }
    }

    private fun verifyPassword(email: String, password: String): Boolean {
        val fakeUser = Login("teste@teste.com", "admin")
        return email == fakeUser.email && password == fakeUser.password
    }
}