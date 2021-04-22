package com.example.businesscontrolv3.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.businesscontrolv3.R

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
    }

    fun enviarNomeParaNextView(view : View){

//        this.nameET = findViewById(R.id.NameET)
//        this.yourNameIsTV = findViewById(R.id.yourNameIs)
//        val valorEditText = nameET.text
//        this.yourNameIsTV.text = getString(R.string.o_seu_nome, valorEditText)
//        yourNameIsTV.visibility = View.VISIBLE

        val intent = Intent(applicationContext, MainActivity::class.java)

        startActivity(intent)
    }
}