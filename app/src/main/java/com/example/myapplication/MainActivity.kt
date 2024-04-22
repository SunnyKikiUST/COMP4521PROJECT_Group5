package com.example.myapplication

import android.app.ActivityOptions
import android.content.pm.ActivityInfo
import android.os.Bundle
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import android.content.Intent
import android.os.Build
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.UPSIDE_DOWN_CAKE)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val btnToCountdown = findViewById<Button>(R.id.btnstarttimer)
       /* btnToCountdown.setOnClickListener{
            Intent(this, CountDown::class.java).also{
                startActivity(it).addFlags(Intent.FLAG_ACTIVITY_NO_ANIMATION);
            }
            //setContentView(R.layout.activity_countdown) // Set the new layout
            //changeLayout(R.layout.activity_countdown)
        }*/
        btnToCountdown.setOnClickListener {
            val intent = Intent(this, CountDown::class.java)
            val options = ActivityOptions.makeCustomAnimation(
                this,
                R.anim.animate_fade_enter,
                R.anim.animate_fade_exit
            ).toBundle()
            startActivity(intent, options)
        }
    }


//    override fun onCreateOptionsMenu(menu: Menu): Boolean {
//        val inflater: MenuInflater = menuInflater
//        inflater.inflate(R.menu.menu, menu)
//        return true
//    }
}