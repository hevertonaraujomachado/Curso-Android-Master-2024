package com.devheverton.meuportiflio

import android.content.Intent
import android.graphics.BitmapFactory
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.core.graphics.drawable.RoundedBitmapDrawable
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory
import com.devheverton.meuportiflio.databinding.ActivityMainBinding

private lateinit var binding: ActivityMainBinding

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val fotoPerfil = BitmapFactory.decodeResource(resources,R.drawable.foto_perfil)
        val circulo = RoundedBitmapDrawableFactory.create(resources,fotoPerfil)
        circulo.isCircular = true
        binding.imgFotoPerfil.setImageDrawable(circulo)

        binding.btProjetos.setOnClickListener {
           val intent = Intent(this,Projetos::class.java)
            startActivity(intent)

            }

        binding.btContato.setOnClickListener {
            val intent = Intent(this,Contato::class.java)
            startActivity(intent)
        }

        }

}