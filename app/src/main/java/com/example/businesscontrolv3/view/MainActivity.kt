package com.example.businesscontrolv3.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.example.businesscontrolv3.R
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

    override fun onPostCreate(savedInstanceState: Bundle?) {
        super.onPostCreate(savedInstanceState)
        Toast.makeText(applicationContext, R.string.texto_toast, Toast.LENGTH_LONG).show()
    }

    fun showSnackbar(view: View){
        Snackbar.make(view,
            R.string.texto_snackbar,Snackbar.LENGTH_LONG).setAction(R.string.texto_confirmacao)
        {
            finish()
        }.show()
    }
}