package com.example.myapplication

import android.app.ActivityOptions
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.Build
import android.view.LayoutInflater
import android.view.View
import androidx.annotation.RequiresApi

class CountDown : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_countdown)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnToGiveUp = findViewById<Button>(R.id.btngiveup)
       /* btnToGiveUp.setOnClickListener{
            Intent(this, MainActivity::class.java).also{
                startActivity(it);
            }
            //setContentView(R.layout.activity_main) // Set the new layout
            //changeLayout(R.layout.activity_main)
        }*/
        btnToGiveUp.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.animate_fade_enter,
                R.anim.animate_fade_exit
            ).toBundle()
            startActivity(intent, options)
        }
    }

}