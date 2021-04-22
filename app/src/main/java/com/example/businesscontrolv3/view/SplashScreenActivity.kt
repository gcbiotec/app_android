package com.example.businesscontrolv3.view

import androidx.appcompat.app.AppCompatActivity
import android.content.Intent
import android.os.Bundle
import android.widget.TextView
import com.example.businesscontrolv3.R
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_splash_screen.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * An example full-screen activity that shows and hides the system UI (i.e.
 * status bar and navigation/system bar) with user interaction.
 */
class SplashScreenActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_splash_screen)

        Picasso.get().load("https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQbGHM8jf1drzKNAtzFYdPGjX6-hS3ojvulNA&usqp=CAU").into(manekinekoIv)

        GlobalScope.launch {
            delay(5000)
//            val intent = Intent(applicationContext, MainActivity::class.java)
              val intent = Intent(applicationContext, LoginActivity::class.java)

            startActivity(intent)
            finish()
        }
    }
}