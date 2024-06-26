package com.devheverton.appdefilmes

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper

import androidx.appcompat.app.AppCompatActivity

import com.devheverton.appdefilmes.view.FormLogin


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Handler(Looper.getMainLooper()).postDelayed({
           val intent = Intent(this, FormLogin::class.java)
            startActivity(intent)
            finish()

        },2000)
        }
    }
